package com.dzbs.controller.message;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.dzbs.bean.common.Message;
import com.dzbs.service.message.MessageImpl;
import com.dzbs.util.common.DataTableUtil;

@Controller
@RequestMapping(value = "/message")
public class MessageContoller {
	
	@Autowired
	private MessageImpl messageDao;
	
	/**
	 * 留言主页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public ModelAndView indexPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("message/index");
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
		List<Message> message = messageDao.findAllMessages();
		// 总记录数
		Integer recordsTotal =  message.size();
		// 关键字过滤后总记录数
		Integer recordsFiltered = recordsTotal;
		dataTableUtil.setResult(recordsTotal, recordsFiltered,messageDao.findAllMessages(dataTableUtil.getPage(), dataTableUtil.getLength()));			
		return dataTableUtil.result();
	}
	/**
	 * 获取联系人相关信息
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveMessage", method = {RequestMethod.POST}, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String saveComment(HttpServletRequest request, HttpServletResponse response) {
		String inputName = request.getParameter("inputName");
		String inputEmail = request.getParameter("inputEmail");
		String inputMessage = request.getParameter("inputMessage");
		JSONObject json = new JSONObject();
		try {
			System.out.println(inputName);
			System.out.println(inputEmail);
			System.out.println(inputMessage);
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
	
	/**
	 * 逻辑删除留言信息
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json; charset=utf-8")
	public @ResponseBody String delete(
			@RequestParam(value = "id", required = true) Integer id,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		JSONObject json = new JSONObject();
		try {
			Message message = messageDao.findById(id).get(0);
			message.setDeleted(true);
			messageDao.updateMessage(message);
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
		}
		return json.toJSONString();
	}
}
