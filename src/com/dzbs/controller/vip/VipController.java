package com.dzbs.controller.vip;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/vip")
public class VipController {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	
	/**
	 * 申请普通会员
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/applyNormal", method = {RequestMethod.POST}, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String applyNormal(HttpServletRequest request, HttpServletResponse response) {
		JSONObject json = new JSONObject();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String username = userDetails.getUsername();
    	Member member = userDetailServiceImpl.findUserByUsername(username);
		try {
			member.setLevel(1);
			userDetailServiceImpl.updateUser(member);
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
		}
		return json.toJSONString();
	}
	
	/**
	 * 申请高级会员
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/applySuper", method = {RequestMethod.POST}, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String applySuper(HttpServletRequest request, HttpServletResponse response) {		
		JSONObject json = new JSONObject();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String username = userDetails.getUsername();
    	Member member = userDetailServiceImpl.findUserByUsername(username);
		try {
			member.setLevel(2);
			userDetailServiceImpl.updateUser(member);
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
		}
		return json.toJSONString();
	}
}
