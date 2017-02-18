package com.dzbs.controller.vip;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
import com.dzbs.bean.common.UserFund;
import com.dzbs.bean.security.Member;
import com.dzbs.dao.UserDao;
import com.dzbs.service.UserDetailServiceImpl;
import com.dzbs.service.fund.UserFundImpl;
@Controller
@RequestMapping(value = "/vip")
public class VipController {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	
	@Autowired
	private UserFundImpl userFundDao;
	
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
			if(userFundDao.findByUserId(member.getId()).size()>0){
				UserFund uf = userFundDao.findByUserId(member.getId()).get(0);
				uf.setUpdate_date(new Date());
				uf.setUpdate_man("sys");
				Date now = new Date();
				if(true == now.before(uf.getLevel_end_time())){
					Date temp = new Date();
					Calendar calendar =new GregorianCalendar(); 
				    calendar.setTime(uf.getLevel_end_time()); 
				    calendar.add(Calendar.DATE,30);
				    temp=calendar.getTime();
				    uf.setLevel_end_time(temp);
				}else{
					Date temp = new Date();
					Calendar calendar =new GregorianCalendar(); 
				    calendar.setTime(temp); 
				    calendar.add(Calendar.DATE,30);
				    temp=calendar.getTime();
				    uf.setLevel_end_time(temp);
				}
				userFundDao.saveUserFund(uf);
			}else{
				UserFund uf = new UserFund();
				uf.setUser_id(member.getId());
				uf.setCreate_date(new Date());
				uf.setCreate_man(username);
				uf.setUpdate_date(new Date());
				uf.setUpdate_man("sys");
				uf.setLevel_start_time(new Date());
				Date end_time = new Date();
				Calendar calendar =new GregorianCalendar(); 
			    calendar.setTime(end_time); 
			    calendar.add(Calendar.DATE,30);
			    end_time=calendar.getTime();
				uf.setLevel_end_time(end_time);
				userFundDao.saveUserFund(uf);
			}
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
			if(userFundDao.findByUserId(member.getId()).size()>0){
				UserFund uf = userFundDao.findByUserId(member.getId()).get(0);
				uf.setUpdate_date(new Date());
				uf.setUpdate_man("sys");
				Date now = new Date();
				if(true == now.before(uf.getLevel_end_time())){
					Date temp = new Date();
					Calendar calendar =new GregorianCalendar(); 
				    calendar.setTime(uf.getLevel_end_time()); 
				    calendar.add(Calendar.DATE,30);
				    temp=calendar.getTime();
				    uf.setLevel_end_time(temp);
				}else{
					Date temp = new Date();
					Calendar calendar =new GregorianCalendar(); 
				    calendar.setTime(temp); 
				    calendar.add(Calendar.DATE,30);
				    temp=calendar.getTime();
				    uf.setLevel_end_time(temp);
				}
				userFundDao.saveUserFund(uf);
			}else{
				UserFund uf = new UserFund();
				uf.setUser_id(member.getId());
				uf.setCreate_date(new Date());
				uf.setCreate_man(username);
				uf.setUpdate_date(new Date());
				uf.setUpdate_man("sys");
				uf.setLevel_start_time(new Date());
				Date end_time = new Date();
				Calendar calendar =new GregorianCalendar(); 
			    calendar.setTime(end_time); 
			    calendar.add(Calendar.DATE,30);
			    end_time=calendar.getTime();
				uf.setLevel_end_time(end_time);
				userFundDao.saveUserFund(uf);
			}			
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
		}
		return json.toJSONString();
	}
}
