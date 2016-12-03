package com.dzbs.www.controller.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dzbs.www.dao.UserDao;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private UserDao userDao;
	
	
	
    @RequestMapping(value = "/index", method = {RequestMethod.GET})
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.setViewName("login/index");
        return modelAndView;
    }
	
    @RequestMapping(value = "/register", method = {RequestMethod.GET})
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.setViewName("login/register");
        return modelAndView;
    }
}
