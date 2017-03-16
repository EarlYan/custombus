package com.dzbs.controller.manage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dzbs.bean.security.Member;
import com.dzbs.service.UserDetailServiceImpl;

@Controller
@RequestMapping(value = "/manage")
public class ManageController {

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	
	/**
	 * 主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.GET,  RequestMethod.POST})
	public ModelAndView indexPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = userDetailServiceImpl.findUserByUsername(username);
        modelAndView.addObject("member", member);	
		modelAndView.setViewName("manage/index");
		return modelAndView;
	}
		
	/**
	 * iframe底主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/front", method = { RequestMethod.GET,  RequestMethod.POST})
	public ModelAndView frontPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("manage/front");
		return modelAndView;
	}
	
}
