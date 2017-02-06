package com.dzbs.controller.property;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dzbs.bean.common.Property;
import com.dzbs.bean.security.Member;
import com.dzbs.service.UserDetailServiceImpl;
import com.dzbs.service.property.PropertyImpl;

@Controller
@RequestMapping(value = "/property")
public class PropertyController {
	
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	
	@Autowired
	private PropertyImpl propertyDao;
	
	/**
	 * 获取联系人相关信息
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
			propertyDao.saveProperty(property);
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
		}
		return json.toJSONString();
	}	
	
}
