package com.dzbs.controller.customer;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.dzbs.bean.security.Member;
import com.dzbs.dao.UserDao;
import com.dzbs.util.common.DataTableUtil;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private UserDao userDao;
	
	
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
		modelAndView.setViewName("customer/index");
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
	
		List<Member> memberList = userDao.findUserByRole("ROLE_PASSENGER");

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
		modelAndView.setViewName("customer/modify");
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
