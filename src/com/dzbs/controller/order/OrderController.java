package com.dzbs.controller.order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.dzbs.bean.common.Order;
import com.dzbs.bean.common.OrderVO;
import com.dzbs.bean.common.Route;
import com.dzbs.bean.security.Member;
import com.dzbs.bean.security.Role;
import com.dzbs.dao.UserDao;
import com.dzbs.service.UserDetailServiceImpl;
import com.dzbs.service.bus.BusImpl;
import com.dzbs.service.order.OrderImpl;
import com.dzbs.service.route.RouteImpl;
import com.dzbs.util.common.DataTableUtil;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;
	
	@Autowired
	private OrderImpl orderDao;
	
	@Autowired
	private RouteImpl routeDao;
	
	@Autowired
	private BusImpl busDao;
	
	/**
	 * 评论主页
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
		modelAndView.addObject("member", member);
		modelAndView.setViewName("order/index");
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
			List<OrderVO> orders = orderDao.findAllOrdersVO();
			// 总记录数
			Integer recordsTotal =  orders.size();
			// 关键字过滤后总记录数
			Integer recordsFiltered = recordsTotal;
			dataTableUtil.setResult(recordsTotal, recordsFiltered,orderDao.findAllOrdersVO(dataTableUtil.getPage(), dataTableUtil.getLength()));
		}else{
			List<OrderVO> orders = orderDao.findByUserIdVO(member.getId());
			// 总记录数
			Integer recordsTotal =  orders.size();
			// 关键字过滤后总记录数
			Integer recordsFiltered = recordsTotal;
			dataTableUtil.setResult(recordsTotal, recordsFiltered,orderDao.findByUserIdVO(member.getId(),dataTableUtil.getPage(), dataTableUtil.getLength()));
		}		
		return dataTableUtil.result();
	}	
	
	/**
	 * 预定主页
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/bookPage", method = { RequestMethod.GET })
	public ModelAndView bookPage(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		Member member = userDetailServiceImpl.findUserByUsername(username);
		int level = member.getLevel();
		String id = request.getParameter("id");
		Route route = routeDao.findById(Integer.valueOf(id)).get(0);
		modelAndView.addObject("route", route);
		float price = priceCal(route.getMileage(),busDao.findById(route.getBus_id()).get(0).getBus_type());
		if(level == 1){//用户会员打折
			price = price * 0.9f;
		}else if(level ==2){
			price = price * 0.8f;
		}
		modelAndView.addObject("price", price);
		if(orderDao.findByRouteId(route.getId()).size()>0){
			List<Order> orders = orderDao.findByRouteId(route.getId());
			List<Integer> seatsOccupied = new ArrayList<Integer>();
			for(Order o : orders){
				seatsOccupied.add(o.getSeat_id());
			}
			modelAndView.addObject("seatsOccupied", seatsOccupied);
		}else{
			modelAndView.addObject("seatsOccupied", null);
		}
		int seat = busDao.findById(route.getBus_id()).get(0).getSeat_number();
		if(seat<=10){
			modelAndView.setViewName("web/smallbus");
		}else if(seat>10 && seat<=20){
			modelAndView.setViewName("web/mediumbus");
		}else{
			modelAndView.setViewName("web/bigbus");
		}	
		return modelAndView;
	}
	
	/**
	 * 订座位
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/book", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String book(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("array[]") List<Integer> seatIds) throws Exception {
		JSONObject json = new JSONObject();
		try {
			String price = request.getParameter("price");			
			String routeId = request.getParameter("routeId");
			
			UserDetails userDetails = (UserDetails) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			String username = userDetails.getUsername();
			int userId = userDao.findUserByUserName(username).getId();
			Route route = routeDao.findById(Integer.valueOf(routeId)).get(0);
			int bookNumber = seatIds.size();
			for(int i=0;i<seatIds.size();i++){
				Order order = new Order();
				order.setBus_id(route.getBus_id());
				order.setCreate_date(new Date());
				order.setCreate_man(username);
				order.setDeleted(false);
				order.setDriver_id(route.getMember_id());
				order.setPay_time(new Date());
				order.setPayed(true);
				order.setPrice(Float.valueOf(price)/bookNumber);
				order.setRoute_id(Integer.valueOf(routeId));
				order.setSeat_id(seatIds.get(i));
				order.setUpdate_date(new Date());
				order.setUpdate_man(username);
				order.setUser_id(userId);
				orderDao.saveOrder(order);
			}		
			json.put("resultCode", 200);
		} catch (Exception e) {
			json.put("resultCode", 500);
			e.printStackTrace();
		}
		return json.toJSONString();
	}
	
	//路程计算器
	public static int priceCal(float routeDistance,int busType){
		float price = 0.0f;
		if(busType ==1){
			price = routeDistance/1000 * 3.5f;
		}else if(busType ==2){
			price = routeDistance/1000 * 2.5f;
		}else if(busType ==3){
			price = routeDistance/1000 * 1.5f;
		}
		return (int) Math.ceil(price);
	}
}
