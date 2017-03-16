package com.dzbs.controller.self;

import java.util.Date;

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
import com.dzbs.bean.security.Member;
import com.dzbs.dao.UserDao;
import com.dzbs.service.UserDetailServiceImpl;

@Controller
@RequestMapping(value = "/self")
public class SelfController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
		
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
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		Member member = userDetailServiceImpl.findUserByUsername(username);
		modelAndView.addObject("member", member);
		modelAndView.setViewName("self/modify");

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
	
	/**
	 * 打开修改页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/passwordModifyPage", method = { RequestMethod.GET })
	public ModelAndView passmodifyPage(
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		Member member = userDetailServiceImpl.findUserByUsername(username);
		modelAndView.addObject("member", member);
		modelAndView.setViewName("self/passwordmodify");
		return modelAndView;
	}
	
	@RequestMapping(value = "/passwordupdate", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String passwordupdate(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JSONObject json = new JSONObject();
		try {
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			Member member = userDao.findUserById(Integer.valueOf(id));
			//修改密码 进行加密处理
			Md5PasswordEncoder md5 = new Md5PasswordEncoder();
			md5.setEncodeHashAsBase64(false);
			String pwd = md5.encodePassword(password, null);
			member.setPassword(pwd);
			userDao.updateUser(member);
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
		}
		return json.toJSONString();
	}
}
