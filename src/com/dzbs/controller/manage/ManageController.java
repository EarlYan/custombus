package com.dzbs.controller.manage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dzbs.dao.UserDao;
import com.dzbs.service.UserDetailServiceImpl;
import com.dzbs.util.common.DataTableUtil;

@Controller
@RequestMapping(value = "/manage")
public class ManageController {

	@Autowired
	private UserDao userDao;
	
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
		modelAndView.setViewName("manage/index");
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
		DataTableUtil dataTableUtil = new DataTableUtil(request);
		System.out.println("===================================");
		System.out.println("起始偏移=" + dataTableUtil.getStart());
		System.out.println("页长=" + dataTableUtil.getLength());
		System.out.println("页码=" + dataTableUtil.getPage());
		System.out.println("排序字段=" + dataTableUtil.getOrderColumn());
		System.out.println("排序顺序=" + dataTableUtil.getOrderDirection());
		System.out.println("搜索关键字=" + dataTableUtil.getSearchValue());
		System.out.println("===================================");
		// 总记录数
		Integer recordsTotal =0;
		// 关键字过滤后总记录数
		Integer recordsFiltered = recordsTotal;
		dataTableUtil.setResult(recordsTotal,recordsFiltered,null);
		return dataTableUtil.result();
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
