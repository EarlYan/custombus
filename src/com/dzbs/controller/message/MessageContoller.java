package com.dzbs.controller.message;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.dzbs.bean.common.Message;
import com.dzbs.dao.UserDao;
import com.dzbs.service.UserDetailServiceImpl;
import com.dzbs.service.message.MessageImpl;

@Controller
@RequestMapping(value = "/message")
public class MessageContoller {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	
	@Autowired
	private MessageImpl messageDao;
	
	/**
	 * 获取联系人相关信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveMessage", method = { RequestMethod.GET, RequestMethod.POST}, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String saveComment(HttpServletRequest request, HttpServletResponse response) {
		String inputName = request.getParameter("inputName");
		String inputEmail = request.getParameter("inputEmail");
		String inputMessage = request.getParameter("inputMessage");
		JSONObject json = new JSONObject();
		try {
			Message mes = new Message();
			mes.setName(inputName);
			mes.setEmail(inputEmail);
			mes.setMessage(inputMessage);
			mes.setCreate_date(new Date());
			messageDao.saveMessage(mes);
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
		}
		return json.toJSONString();
	}
}
