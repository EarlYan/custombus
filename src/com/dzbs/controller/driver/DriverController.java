package com.dzbs.controller.driver;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.dzbs.bean.security.Member;
import com.dzbs.dao.UserDao;
import com.dzbs.service.UserDetailServiceImpl;
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
			String id = request.getParameter("id");
			String licenseUrl = request.getParameter("licenseUrl");
			Member member = userDao.findUserById(Integer.valueOf(id));
			member.setLicenseUrl(licenseUrl);
			userDao.updateUser(member);
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
		}
		return json.toJSONString();
	}
}
