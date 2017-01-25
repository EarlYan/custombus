package com.dzbs.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dzbs.bean.security.Member;
import com.dzbs.dao.UserDao;
import com.dzbs.service.UserDetailServiceImpl;

@Controller
@RequestMapping(value = "/web")
public class WebController {

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
		modelAndView.setViewName("web/index");
		return modelAndView;
	}
	
	/**
	 * 加入会员主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/vip", method = { RequestMethod.GET })
	public ModelAndView vipPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("web/vip");
		return modelAndView;
	}
	
	/**
	 * 关于我们主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/aboutus", method = { RequestMethod.GET })
	public ModelAndView aboutusPage(HttpServletRequest request,
			HttpServletResponse response) {	
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	String username = userDetails.getUsername();
    	Member member = userDetailServiceImpl.findUserByUsername(username);
    	Integer memberLevel = member.getLevel();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("memberLevel", memberLevel);
		modelAndView.setViewName("web/aboutus");
		return modelAndView;
	}
	
	/**
	 * 我们团队主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/agents", method = { RequestMethod.GET })
	public ModelAndView agentsPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("web/agents");
		return modelAndView;
	}
	
	/**
	 * FAQ主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/faq", method = { RequestMethod.GET })
	public ModelAndView faqPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("web/faq");
		return modelAndView;
	}
	
	/**
	 * 联系我们主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/contactus", method = { RequestMethod.GET })
	public ModelAndView contactusPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("web/contactus");
		return modelAndView;
	}
	
	/**
	 * 众筹路线主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/property", method = { RequestMethod.GET })
	public ModelAndView propertyPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("web/property");
		return modelAndView;
	}
	
	/**
	 * 小巴预定主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/smallbus", method = { RequestMethod.GET })
	public ModelAndView smallbusPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("web/smallbus");
		return modelAndView;
	}
	
	/**
	 * 中巴预定主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/mediumbus", method = { RequestMethod.GET })
	public ModelAndView mediumbusPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("web/mediumbus");
		return modelAndView;
	}
	
	/**
	 * 大巴预定主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/bigbus", method = { RequestMethod.GET })
	public ModelAndView bigbusPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("web/bigbus");
		return modelAndView;
	}
	
	/**
	 * 路线表格主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/buslist", method = { RequestMethod.GET })
	public ModelAndView buslistPage(HttpServletRequest request,
			HttpServletResponse response) {
		String price = request.getParameter("price");
		String routes = request.getParameter("routes");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("web/buslist");
		return modelAndView;
	}
}
