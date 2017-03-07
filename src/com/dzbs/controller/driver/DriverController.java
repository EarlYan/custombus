package com.dzbs.controller.driver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.dzbs.bean.common.Bus;
import com.dzbs.bean.common.License;
import com.dzbs.bean.security.Member;
import com.dzbs.dao.UserDao;
import com.dzbs.service.UserDetailServiceImpl;
import com.dzbs.service.bus.BusImpl;
import com.dzbs.service.license.LicenseImpl;
import com.dzbs.util.common.DataTableUtil;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping(value = "/driver")
public class DriverController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	
	@Autowired
	private LicenseImpl licenseDao;
	
	@Autowired
	private BusImpl busDao;
	
	/**
	 * 客户主页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public ModelAndView indexPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("driver/index");
		return modelAndView;
	}
	
	/**
	 * 获取数据
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/data", method = { RequestMethod.POST }, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String data(HttpServletRequest request, HttpServletResponse response) {
		/**
		 * 获取查询参数
		 */
		DataTableUtil dataTableUtil = new DataTableUtil(request);
		System.out.println("===================================");
		System.out.println("起始偏移=" + dataTableUtil.getStart());
		System.out.println("页长=" + dataTableUtil.getLength());
		System.out.println("页码=" + dataTableUtil.getPage());
		System.out.println("排序字段=" + dataTableUtil.getOrderColumn());
		System.out.println("排序顺序=" + dataTableUtil.getOrderDirection());
		System.out.println("搜索关键字=" + dataTableUtil.getSearchValue());
		System.out.println("===================================");
	
		List<Member> memberList = userDao.findUserByRole("ROLE_DRIVER");

		// 总记录数
		Integer recordsTotal =  memberList.size();
		// 关键字过滤后总记录数
		Integer recordsFiltered = recordsTotal;
		
		//Google JSon解析
		Gson gson = new GsonBuilder()  
				        .excludeFieldsWithoutExposeAnnotation() 
				        .enableComplexMapKeySerialization() 
				        .serializeNulls().setDateFormat("yyyy-MM-dd")
				        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
				        .setPrettyPrinting()  
				        .setVersion(1.0)       
				        .create();  
		String s2 = gson.toJson(memberList);
		List<Member> members = gson.fromJson(s2,  
		                new TypeToken<List<Member>>() {  
		                }.getType());  

		dataTableUtil.setResult(recordsTotal, recordsFiltered,members);
		return dataTableUtil.result();
	}
	
	/**
	 * 司机资格认证主页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/identify", method = { RequestMethod.GET })
	public ModelAndView identifyPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		Member member = userDetailServiceImpl.findUserByUsername(username);
		modelAndView.addObject("member", member);
		if(licenseDao.findByMemberId(member.getId()).size()>0){
			License license  = licenseDao.findByMemberId(member.getId()).get(0);
			modelAndView.addObject("license", license);
		}else{
			modelAndView.addObject("license", null);
		}
		if(busDao.findByMemberId(member.getId()).size()>0){
			Bus bus = busDao.findByMemberId(member.getId()).get(0);
			modelAndView.addObject("bus", bus);
		}else{
			modelAndView.addObject("bus", null);
		}
		modelAndView.setViewName("driver/identify");
		return modelAndView;
	}
	
	/**
	 * 资格认证上传
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/upload", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String upload(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JSONObject json = new JSONObject();
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			String username = userDetails.getUsername();		
			String id = request.getParameter("id");
			String bus_plate_number = request.getParameter("bus_plate_number");
			String bus_seat_number = request.getParameter("bus_seat_number");
			String bus_type = request.getParameter("bus_type");
			String licenseType = request.getParameter("licenseType");
			String license_serial_number = request.getParameter("license_serial_number");
			String license_start_time = request.getParameter("license_start_time");
			String license_time_limit = request.getParameter("license_time_limit");
			String imgurl = request.getParameter("imgurl");
			if(busDao.findByMemberId(Integer.valueOf(id)).size()>0){
				Bus bus = busDao.findByMemberId(Integer.valueOf(id)).get(0);
				bus.setMember_id(Integer.valueOf(id));
				bus.setPlate_number(bus_plate_number);
				bus.setSeat_number(Integer.valueOf(bus_seat_number));
				bus.setBus_type(Integer.valueOf(bus_type));
				bus.setCreate_date(new Date());
				bus.setCreate_man(username);
				busDao.updateBus(bus);
			}else{
				Bus bus = new Bus();
				bus.setMember_id(Integer.valueOf(id));
				bus.setPlate_number(bus_plate_number);
				bus.setSeat_number(Integer.valueOf(bus_seat_number));
				bus.setBus_type(Integer.valueOf(bus_type));
				bus.setCreate_date(new Date());
				bus.setCreate_man(username);
				busDao.saveBus(bus);
			}
			if(licenseDao.findByMemberId(Integer.valueOf(id)).size()>0){
				License license =licenseDao.findByMemberId(Integer.valueOf(id)).get(0);
				license.setMember_id(Integer.valueOf(id));
				license.setType(licenseType);
				license.setSerial_number(license_serial_number);
				Date  start_time =  new SimpleDateFormat("yyyy-MM-dd").parse(license_start_time);
				license.setStart_time(start_time);
				license.setTime_limit(Integer.valueOf(license_time_limit));
				license.setImgurl(imgurl);
				license.setCreate_date(new Date());
				license.setCreate_man(username);
				license.setApply_date(new Date());
				licenseDao.updateLicense(license);
			}else{
				License license = new License();
				license.setMember_id(Integer.valueOf(id));
				license.setType(licenseType);
				license.setSerial_number(license_serial_number);
				Date  start_time =  new SimpleDateFormat("yyyy-MM-dd").parse(license_start_time);
				license.setStart_time(start_time);
				license.setTime_limit(Integer.valueOf(license_time_limit));
				license.setImgurl(imgurl);
				license.setCreate_date(new Date());
				license.setCreate_man(username);
				license.setApply_date(new Date());
				licenseDao.saveLicense(license);
			}			
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
		}
		return json.toJSONString();
	}
	
	/**
	 * 打开修改页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = "/checkPage", method = { RequestMethod.GET }, produces = "application/json; charset=utf-8")
	public ModelAndView checkPage(
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		String id = request.getParameter("id");
		Member member = userDao.findUserById(Integer.valueOf(id));
		Bus bus = busDao.findByMemberId(member.getId()).get(0);
		License license = licenseDao.findByMemberId(member.getId()).get(0);
		modelAndView.addObject("member", member);
		modelAndView.addObject("bus", bus);
		modelAndView.addObject("license", license);
		modelAndView.setViewName("driver/checkPage");
		return modelAndView;
	}
	
	/**
	 * 资格审核
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/check", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String check(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JSONObject json = new JSONObject();
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			String username = userDetails.getUsername();
			Member adminMember = userDetailServiceImpl.findUserByUsername(username);
			String id = request.getParameter("id");
			Member driver = userDao.findUserById(Integer.valueOf(id));
			driver.setUpdate_date(new Date());
			driver.setLicense(true);
			userDao.updateUser(driver);
			License  license = licenseDao.findByMemberId(driver.getId()).get(0);
			license.setConfirm_date(new Date());
			license.setUpdate_man(adminMember.getUsername());
			license.setUpdate_date(new Date());
			licenseDao.updateLicense(license);
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
		}
		return json.toJSONString();
	}
	
	/**
	 * 打开修改页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping(value = "/modifyPage", method = { RequestMethod.GET })
	public ModelAndView modifyPage(
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		String id = request.getParameter("id");
		Member member = userDao.findUserById(Integer.valueOf(id));
		modelAndView.addObject("member", member);
		modelAndView.setViewName("driver/modify");
		return modelAndView;
	}
	
	@RequestMapping(value = "/update", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String update(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JSONObject json = new JSONObject();
		try {
			String id = request.getParameter("id");
			String memberRealName = request.getParameter("memberRealName");
			String memberEmail = request.getParameter("memberEmail");
			String memberGender = request.getParameter("memberGender");
			String memberMobile = request.getParameter("memberMobile");
			String memberImageURL = request.getParameter("memberImageURL");
			Member member = userDao.findUserById(Integer.valueOf(id));
			member.setRealname(memberRealName);
			member.setEmail(memberEmail);
			member.setGender(Boolean.valueOf(memberGender));
			member.setMobile(memberMobile);
			member.setImgurl(memberImageURL);
			member.setUpdate_date(new Date());
			userDao.updateUser(member);
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
			// LOG.error(e.getMessage());
		}
		return json.toJSONString();
	}
}
