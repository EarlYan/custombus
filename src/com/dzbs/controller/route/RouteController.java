package com.dzbs.controller.route;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.dzbs.bean.common.Route;
import com.dzbs.bean.common.RouteVO;
import com.dzbs.bean.security.Member;
import com.dzbs.bean.security.Role;
import com.dzbs.service.UserDetailServiceImpl;
import com.dzbs.service.bus.BusImpl;
import com.dzbs.service.route.RouteImpl;
import com.dzbs.util.common.DataTableUtil;


@Controller
@RequestMapping(value = "/route")
public class RouteController {

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	
	@Autowired
	private RouteImpl routeDao;
	
	@Autowired
	private BusImpl busDao;
	
	/**
	 * 路线主页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public ModelAndView indexPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		Member member = userDetailServiceImpl.findUserByUsername(username);
		Set<Role> mRoles = member.getRoles();
		Iterator<Role> it = mRoles.iterator();
		String roleCode = "";
		while(it.hasNext()){
			Role role = it.next();
			roleCode = role.getCode();
		}
		if(roleCode.equals("ROLE_ADMIN")){
			modelAndView.addObject("role", "admin");
		}else if(roleCode.equals("ROLE_DRIVER")){
			modelAndView.addObject("role", "driver");
		}
		modelAndView.setViewName("route/index");
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
	
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		Member member = userDetailServiceImpl.findUserByUsername(username);
		Set<Role> mRoles = member.getRoles();
		Iterator<Role> it = mRoles.iterator();
		String roleCode = "";
		while(it.hasNext()){
			Role role = it.next();
			roleCode = role.getCode();
		}
		if(roleCode.equals("ROLE_ADMIN")){
			List<RouteVO> routes = routeDao.findAllRoutesVO();
			Integer recordsTotal = routes.size();
			Integer recordsFiltered = recordsTotal;
			dataTableUtil.setResult(recordsTotal, recordsFiltered,routeDao.findAllRoutesVO(dataTableUtil.getPage(), dataTableUtil.getLength()));
		}else if(roleCode.equals("ROLE_DRIVER")){
			List<RouteVO> routes = routeDao.findByDriverIdVO(member.getId());
			Integer recordsTotal = routes.size();
			Integer recordsFiltered = recordsTotal;
			dataTableUtil.setResult(recordsTotal, recordsFiltered,routeDao.findByDriverIdVO(dataTableUtil.getPage(), dataTableUtil.getLength(),member.getId()));
		}
		return dataTableUtil.result();
	}
	
	/**
	 * 判断车类型以及计算价格
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/judge", method = {RequestMethod.POST}, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String judgeType(HttpServletRequest request, HttpServletResponse response) {
		String inputStart = request.getParameter("inputStart");
		String inputEnd = request.getParameter("inputEnd");
		String chooseBusType = request.getParameter("chooseBusType");
		String chooseTime = request.getParameter("chooseTime");
		String routeDistance = request.getParameter("routeDistance");
		JSONObject json = new JSONObject();
		try {
			//判断是否已经开此路线
			List<Route> routes = routeDao.
					findByStartEndTimeAndNotFull(inputStart, inputEnd, chooseTime);	
			if(routes.size()>0){
				for(int i=0;i<routes.size();i++){
					Integer busType = busDao.
							findById(routes.get(i).getBus_id()).get(0).getBus_type();
					if(busType != Integer.valueOf(chooseBusType)){
						//从路线中移除
						routes.remove(routes.get(i));
					}
				}
			}
			if(routes.size()>0){
				float price = priceCal(Float.valueOf(routeDistance),Integer.valueOf(chooseBusType));
				ModelAndView mav = new ModelAndView("redirect:../web/buslist");
				mav.addObject("price",price);
				mav.addObject("routes", routes);
				mav.setViewName("../web/buslist");
			}else{
				ModelAndView mav = new ModelAndView("redirect:../web/property");
				mav.setViewName("../web/property");
			}				
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
		}
		return json.toJSONString();
	}
	
	//路程计算器
	public static float priceCal(float routeDistance,int busType){
		float price = 0.0f;
		if(busType ==1){
			price = routeDistance * 3.5f;
		}else if(busType ==2){
			price = routeDistance * 2.5f;
		}else if(busType ==3){
			price = routeDistance * 1.5f;
		}
		return price;
	}
	
	/**
	 * 删除评论信息
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
			Route route = routeDao.findById(id).get(0);
			route.setDeleted(true);
			routeDao.updateRoute(route);
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
		}
		return json.toJSONString();
	}
	
	/**
	 * 打开修改页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/modifyPage", method = { RequestMethod.GET })
	public ModelAndView modifyPage(
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		String id = request.getParameter("id");
		Route route = routeDao.findById(Integer.valueOf(id)).get(0);
		modelAndView.addObject("route", route);
		modelAndView.setViewName("route/modify");
		return modelAndView;
	}

	@RequestMapping(value = "/update", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String update(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JSONObject json = new JSONObject();
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			String username = userDetails.getUsername();
			String id = request.getParameter("id");
			String route_start_location = request.getParameter("route_start_location");
			String route_end_location = request.getParameter("route_end_location");
			String route_start_time = request.getParameter("route_start_time");
			String route_mileage = request.getParameter("route_mileage");
			String route_about_time = request.getParameter("route_about_time");
			Route route = routeDao.findById(Integer.valueOf(id)).get(0);
			route.setStart_location(route_start_location);
			route.setEnd_location(route_end_location);
			Date  start_time =  new SimpleDateFormat("HH:mm:ss").parse(route_start_time);
			route.setStart_time(start_time);
			route.setMileage(Float.valueOf(route_mileage));
			route.setAbout_time(Integer.valueOf(route_about_time));
			route.setUpdate_date(new Date());
			route.setUpdate_man(username);
			routeDao.updateRoute(route);
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
		}
		return json.toJSONString();
	}
}
