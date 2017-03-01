package com.dzbs.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dzbs.bean.common.Bus;
import com.dzbs.bean.common.Property;
import com.dzbs.bean.common.Route;
import com.dzbs.bean.common.RouteVO;
import com.dzbs.bean.security.Member;
import com.dzbs.dao.UserDao;
import com.dzbs.service.UserDetailServiceImpl;
import com.dzbs.service.bus.BusImpl;
import com.dzbs.service.property.PropertyImpl;
import com.dzbs.service.route.RouteImpl;

@Controller
@RequestMapping(value = "/web")
public class WebController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	
	@Autowired
	private PropertyImpl propertyDao;
	
	@Autowired
	private RouteImpl routeDao;
	
	@Autowired
	private BusImpl busDao;
	
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
        if(member != null){
        	modelAndView.addObject("member", member);	
        }else{
        	modelAndView.addObject("member", null);
        } 
        List<Property> propertyList = propertyDao.findLatestProperties();
        modelAndView.addObject("propertyList",propertyList);
        List<Member> drivers = userDao.findRandomDriver();
        modelAndView.addObject("drivers",drivers);
        List<RouteVO> routes = routeDao.findAllRoutesVO();
        modelAndView.addObject("routes",routes);
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
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Member member = userDetailServiceImpl.findUserByUsername(username);
		if(member != null){
			Integer memberLevel = member.getLevel();
			modelAndView.addObject("member", member);	
			modelAndView.addObject("memberLevel", memberLevel);
		}else{
			modelAndView.addObject("member", null);
			modelAndView.addObject("memberLevel", 0);
		}
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
		ModelAndView modelAndView = new ModelAndView();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = userDetailServiceImpl.findUserByUsername(username);
        if(member != null){
        	modelAndView.addObject("member", member);	
        }else{
        	modelAndView.addObject("member", null);
        } 
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
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = userDetailServiceImpl.findUserByUsername(username);
        if(member != null){
        	modelAndView.addObject("member", member);	
        }else{
        	modelAndView.addObject("member", null);
        } 
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
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = userDetailServiceImpl.findUserByUsername(username);
        if(member != null){
        	modelAndView.addObject("member", member);	
        }else{
        	modelAndView.addObject("member", null);
        } 
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
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = userDetailServiceImpl.findUserByUsername(username);
        if(member != null){
        	modelAndView.addObject("member", member);	
        }else{
        	modelAndView.addObject("member", null);
        } 
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
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = userDetailServiceImpl.findUserByUsername(username);
        if(member != null){
        	modelAndView.addObject("member", member);	
        }else{
        	modelAndView.addObject("member", null);
        } 
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
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = userDetailServiceImpl.findUserByUsername(username);
        if(member != null){
        	modelAndView.addObject("member", member);	
        }else{
        	modelAndView.addObject("member", null);
        } 
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
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = userDetailServiceImpl.findUserByUsername(username);
        if(member != null){
        	modelAndView.addObject("member", member);	
        }else{
        	modelAndView.addObject("member", null);
        } 
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
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = userDetailServiceImpl.findUserByUsername(username);
        if(member != null){
        	modelAndView.addObject("member", member);	
        }else{
        	modelAndView.addObject("member", null);
        } 
		modelAndView.setViewName("web/bigbus");
		return modelAndView;
	}
		
	/**
	 * 联系我们主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/companyshow", method = { RequestMethod.GET })
	public ModelAndView companyshowPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("web/companyshow");
		return modelAndView;
	}
	
	/**
	 * 司机详情主页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/driverdetail", method = { RequestMethod.GET })
	public ModelAndView driverdetail(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = userDetailServiceImpl.findUserByUsername(username);
        if(member != null){
        	modelAndView.addObject("member", member);	
        }else{
        	modelAndView.addObject("member", null);
        } 
        String id = request.getParameter("id");
        Member driver = userDao.findUserById(Integer.valueOf(id));
        Bus bus = busDao.findByMemberId(Integer.valueOf(id)).get(0);
        Route route =routeDao.findByDriverId(Integer.valueOf(id)).get(0);
        modelAndView.addObject("driver", driver);
        modelAndView.addObject("bus", bus);
        modelAndView.addObject("route", route);
		modelAndView.setViewName("web/driverdetail");
		return modelAndView;
	}
	
	/**
	 * 线路详情
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/routedetail", method = { RequestMethod.GET })
	public ModelAndView routedetail(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = userDetailServiceImpl.findUserByUsername(username);
        if(member != null){
        	modelAndView.addObject("member", member);	
        }else{
        	modelAndView.addObject("member", null);
        } 
		String id = request.getParameter("id");
		Route route = routeDao.findById(Integer.valueOf(id)).get(0);
		modelAndView.addObject("route", route);
		modelAndView.setViewName("web/routedetail");
		return modelAndView;
	}
	
	/**
	 * 众筹详情
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/propertydetail", method = { RequestMethod.GET })
	public ModelAndView propertydetail(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Member member = userDetailServiceImpl.findUserByUsername(username);
        if(member != null){
        	modelAndView.addObject("member", member);	
        }else{
        	modelAndView.addObject("member", null);
        } 
		String id = request.getParameter("id");
		Property property = propertyDao.findById(Integer.valueOf(id)).get(0);
		System.out.println(property);
		modelAndView.addObject("property", property);
		modelAndView.setViewName("web/propertydetail");
		return modelAndView;
	}
}
