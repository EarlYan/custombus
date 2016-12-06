package com.dzbs.www.controller.route;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dzbs.www.service.UserDetailServiceImpl;


@Controller
@RequestMapping(value = "/route")
public class RouteController {

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	
	/**
	 * 主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public ModelAndView indexPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("route/index");
		return modelAndView;
	}
	
	
}
