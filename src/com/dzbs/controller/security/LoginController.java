package com.dzbs.controller.security;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dzbs.bean.security.Member;
import com.dzbs.bean.security.Role;
import com.dzbs.dao.UserDao;
import com.dzbs.service.UserDetailServiceImpl;


/**
 * @author EarlYan
 * 登陆相关操作
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	
    @RequestMapping(value = "/index", method = {RequestMethod.GET})
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.setViewName("login/index");
        return modelAndView;
    }
	
    @RequestMapping(value = "/register", method = {RequestMethod.GET})
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.setViewName("login/index");
        return modelAndView;
    }
    
    @RequestMapping(value = "/forgetpassword", method = {RequestMethod.GET})
	public ModelAndView forgetpassword(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.setViewName("login/forgetpassword");
        return modelAndView;
    }
    
    @RequestMapping(value = "/modify", method = {RequestMethod.GET})
	public ModelAndView modify(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.setViewName("login/modify");
        return modelAndView;
    }
    
    @RequestMapping(value = "/checkMobile", method = {RequestMethod.GET}, produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String checkMobile(HttpServletRequest request, HttpServletResponse response){
    	String mobile = request.getParameter("mobile");
    	Member member = userDetailServiceImpl.findUserByMobile(mobile);
    	if(member != null){
    		return "true";
    	}
    	else{
    		return "false";
    	}
    }
    
    @RequestMapping(value = "/checkExist", method = {RequestMethod.POST}, produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String checkExist(HttpServletRequest request, HttpServletResponse response){
    	String mobile = request.getParameter("mobile");
    	String username = request.getParameter("username");
    	Member member = userDetailServiceImpl.findUserByUserNameAndMobile(username,mobile);
    	if(member != null){
    		Md5PasswordEncoder md5 = new Md5PasswordEncoder(); 
        	md5.setEncodeHashAsBase64(false);
        	String pwd = md5.encodePassword("password", null); 
        	member.setPassword(pwd);
    		userDetailServiceImpl.updateUser(member);
    		return "true";
    	}
    	else{
    		return "false";
    	}
    }
    
    @RequestMapping(value = "/isMobileCanModify", method = {RequestMethod.GET}, produces = "text/plain; charset=utf-8")
    @ResponseBody
    public String isMobileCanModify(HttpServletRequest request, HttpServletResponse response){
    	String mobile = request.getParameter("mobile");
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String username = userDetails.getUsername();
    	Member member = userDetailServiceImpl.findUserByUsername(username);
    	
    	Member mobilemember = userDetailServiceImpl.findUserByMobile(mobile);
    	
    	if(mobilemember == null){
    		return "true";
    	}
    	else if(mobilemember.getId() == member.getId()){
    		return "true";
    	}
    	else{
    		return "false";
    	}
    }
    
    @RequestMapping(value = "/auth", method = {RequestMethod.GET})
	public ModelAndView auth(HttpServletRequest request, HttpServletResponse response){
    	String path = "";
    	try{
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        	String username = userDetails.getUsername();
        	Member member = userDetailServiceImpl.findUserByUsername(username);
        	
        	path = "login/index";
    	}
    	catch(Exception e){
    		path = "login/auth";
    	}

        ModelAndView modelAndView = new ModelAndView();  
        modelAndView.setViewName(path);
        return modelAndView;
    }
    
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    @ResponseBody
    public String addMember(HttpServletRequest request, HttpServletResponse response){
    	String inputRegisterUserName = request.getParameter("inputRegisterUserName");
    	String inputRegisterTel = request.getParameter("inputRegisterTel");
    	String inputRegisterEmail = request.getParameter("inputRegisterEmail");
    	String inputRegisterPassword = request.getParameter("inputRegisterPassword");
    	String inputRegisterType = request.getParameter("inputRegisterType");
    	
        Member member = new Member();
        member.setUsername(inputRegisterUserName);
    	Md5PasswordEncoder md5 = new Md5PasswordEncoder(); 
    	md5.setEncodeHashAsBase64(false);
    	String password = md5.encodePassword(inputRegisterPassword, null); 
    	member.setPassword(password);
        member.setMobile(inputRegisterTel);
        member.setEmail(inputRegisterEmail);
        member.setCreate_date(new Date());
        member.setUpdate_date(new Date());
        Set<Role> set = new HashSet<Role>();
        Role ro = new Role();
        if(inputRegisterType.equals("1")){
        	ro = userDao.findRoleByRoleCode("ROLE_PASSENGER");
        }else if(inputRegisterType.equals("2")){
        	ro = userDao.findRoleByRoleCode("ROLE_DRIVER");
        }    
        set.add(ro);
        member.setRoles(set);
        userDao.saveUser(member);
        return "true";
    }
    
    /**
     * 异常处理方法
     * @param ex
     * @return
     */
    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception ex){
        ModelAndView mv = new ModelAndView("serverError");
        mv.addObject("exception", ex.getMessage());
        ex.printStackTrace();
        return mv;
    }
    
}
