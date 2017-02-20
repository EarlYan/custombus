package com.dzbs.controller.property;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.dzbs.bean.common.DriverVO;
import com.dzbs.bean.common.Property;
import com.dzbs.bean.common.Route;
import com.dzbs.bean.common.RouteVO;
import com.dzbs.bean.security.Member;
import com.dzbs.bean.security.Role;
import com.dzbs.dao.UserDao;
import com.dzbs.service.UserDetailServiceImpl;
import com.dzbs.service.bus.BusImpl;
import com.dzbs.service.property.PropertyImpl;
import com.dzbs.service.route.RouteImpl;
import com.dzbs.util.baidu.GetLatAndLngByBaidu;
import com.dzbs.util.common.DataTableUtil;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping(value = "/property")
public class PropertyController {
	
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	
	@Autowired
	private PropertyImpl propertyDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RouteImpl routeDao;
	
	@Autowired
	private BusImpl busDao;
	
	/**
	 * 保存众筹
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveProperty", method = {RequestMethod.POST}, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String saveProperty(HttpServletRequest request, HttpServletResponse response) {
		JSONObject json = new JSONObject();
		String inputPropertyName = request.getParameter("inputPropertyName");
		String inputPropertyEmail = request.getParameter("inputPropertyEmail");
		String inputPropertyPhone = request.getParameter("inputPropertyPhone");
		String inputPropertyLocationStart = request.getParameter("inputPropertyLocationStart");
		String inputPropertyLocationEnd = request.getParameter("inputPropertyLocationEnd");
		String inputPropertyTimeStart = request.getParameter("inputPropertyTimeStart");
		String inputPropertyTimeEnd = request.getParameter("inputPropertyTimeEnd");
		String inputPropertyNotes = request.getParameter("inputPropertyNotes");
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = userDetailServiceImpl.findUserByUsername(username);
        String create_man = null;
        if(member != null){
        	create_man = member.getUsername();
        }else{
        	create_man = "sys";
        } 
		try {
			Property property = new Property();
			property.setCreate_date(new Date());
			property.setCreate_man(create_man);
			property.setUpdate_date(new Date());
			property.setName(inputPropertyName);
			property.setEmail(inputPropertyEmail);
			property.setMobile(inputPropertyPhone);
			property.setStartLoaction(inputPropertyLocationStart);
			property.setEndLocation(inputPropertyLocationEnd);
			Date  go =  new SimpleDateFormat("HH:mm:ss").parse(inputPropertyTimeStart);
			Date  back =  new SimpleDateFormat("HH:mm:ss").parse(inputPropertyTimeEnd);
			property.setGoTime(go);
			property.setBackTime(back);
			property.setNotes(inputPropertyNotes);
			String[] strsStart = GetLatAndLngByBaidu.getCoordinate(inputPropertyLocationStart);
			String[] strsEnd = GetLatAndLngByBaidu.getCoordinate(inputPropertyLocationEnd);
			double distance = GetLatAndLngByBaidu.
					getDistance(Double.valueOf(strsStart[0]), Double.valueOf(strsStart[1]), Double.valueOf(strsEnd[0]), Double.valueOf(strsEnd[1]));
			property.setDistance(distance);
			propertyDao.saveProperty(property);
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
		}
		return json.toJSONString();
	}	
	
	/**
	 * 众筹管理主页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public ModelAndView indexPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("property/index");
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
	
		List<Property> properties = propertyDao.findAllProperties();
		Integer recordsTotal = properties.size();
		Integer recordsFiltered = recordsTotal;

		dataTableUtil.setResult(recordsTotal, recordsFiltered,properties);
		return dataTableUtil.result();
	}
	
	/**
	 * 删除评论信息
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public @ResponseBody String delete(
			@RequestParam(value = "id", required = true) Integer id,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JSONObject json = new JSONObject();
		try {
			Property property = propertyDao.findById(id).get(0);
			property.setDeleted(true);
			propertyDao.updateProperty(property);
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
		Property property = propertyDao.findById(Integer.valueOf(id)).get(0);
		modelAndView.addObject("property", property);
		modelAndView.setViewName("property/modify");
		return modelAndView;
	}

	@RequestMapping(value = "/update", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String update(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JSONObject json = new JSONObject();
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			String username = userDetails.getUsername();
			String id = request.getParameter("id");
			String startLoaction = request.getParameter("startLoaction");
			String endLocation = request.getParameter("endLocation");
			String goTime = request.getParameter("goTime");
			String backTime = request.getParameter("backTime");
			String notes = request.getParameter("notes");
			String distance = request.getParameter("distance");
			Property property = propertyDao.findById(Integer.valueOf(id)).get(0);
			property.setStartLoaction(startLoaction);
			property.setEndLocation(endLocation);
			Date go = new SimpleDateFormat("HH:mm:ss").parse(goTime);
			Date back = new SimpleDateFormat("HH:mm:ss").parse(backTime);
			property.setGoTime(go);
			property.setBackTime(back);
			property.setNotes(notes);
			property.setDistance(Double.valueOf(distance));
			property.setUpdate_date(new Date());
			property.setUpdate_man(username);
			propertyDao.updateProperty(property);
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
		}
		return json.toJSONString();
	}
	
	/**
	 * 打开分配页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/assignPage", method = { RequestMethod.GET })
	public ModelAndView assignPage(
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		String id = request.getParameter("id");
		Property property = propertyDao.findById(Integer.valueOf(id)).get(0);
		modelAndView.addObject("property", property);		
		modelAndView.setViewName("property/assign");
		return modelAndView;
	}
	
	/**
	 * 获取数据
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/assigndata", method = { RequestMethod.POST }, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String assigndata(HttpServletRequest request, HttpServletResponse response) {
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
	
		List<DriverVO> vos  = userDao.findFreeDriver();
		Integer recordsTotal = vos.size();
		Integer recordsFiltered = recordsTotal;

		dataTableUtil.setResult(recordsTotal, recordsFiltered,userDao.findFreeDriver(dataTableUtil.getPage(), dataTableUtil.getLength()));
		return dataTableUtil.result();
	}
	
	@RequestMapping(value = "/assign", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String assign(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JSONObject json = new JSONObject();
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			String username = userDetails.getUsername();
			String id = request.getParameter("id");
			String propertyId = request.getParameter("propertyId");
			Integer busId = busDao.findByMemberId(Integer.valueOf(id)).get(0).getId();
			Property property =propertyDao.findById(Integer.valueOf(propertyId)).get(0);
			Route route = new Route();
			route.setCreate_date(new Date());
			route.setCreate_man(username);
			route.setDeleted(false);
			route.setEnd_location(property.getEndLocation());
			route.setStart_location(property.getStartLoaction());
			route.setFull(false);
			route.setMember_id(Integer.valueOf(id));
			route.setStart_time(property.getGoTime());
			route.setUpdate_date(new Date());
			route.setUpdate_man(username);
			route.setMileage((float)property.getDistance());
			route.setAbout_time((int)property.getDistance()/60);
			route.setBus_id(busId);
			routeDao.saveRoute(route);
			property.setDeleted(true);
			propertyDao.updateProperty(property); 
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
		}
		return json.toJSONString();
	}
}
