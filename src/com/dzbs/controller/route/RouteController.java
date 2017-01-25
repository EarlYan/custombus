package com.dzbs.controller.route;

import java.util.Date;
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
import com.dzbs.bean.common.Message;
import com.dzbs.bean.common.Route;
import com.dzbs.bean.security.Member;
import com.dzbs.service.UserDetailServiceImpl;
import com.dzbs.service.bus.BusImpl;
import com.dzbs.service.route.RouteImpl;


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
			price = routeDistance * 2.5f;
		}else if(busType ==2){
			price = routeDistance * 1.5f;
		}else if(busType ==3){
			price = routeDistance * 0.5f;
		}
		return price;
	}
}
