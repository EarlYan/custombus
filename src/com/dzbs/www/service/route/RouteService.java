package com.dzbs.www.service.route;

import java.util.List;

import com.dzbs.www.bean.common.Route;

public interface RouteService {

	public void saveRoute(Route route);
	
	public void updateRoute(Route route);
	
	public void deleteRoute(Route route);
	
	/**
	 * 用id进行查询
	 * @param id
	 * @return List<Route>
	 */
	public List<Route> findById(Integer id);
	
	/**
	 * 查询所有线路
	 * @return List<Route>
	 */
	public List<Route> findAllRoutes();
	
	/**
	 * 用start_location,end_location进行查询(起终点查询)
	 * @param start_location,end_location
	 * @return List<Route>
	 */
	public List<Route> findByStartAndEndLocation(String start_location,String end_location);
	
	/**
	 * 用start_location,end_location,start_time进行查询(起终点时间查询)
	 * @param start_location,end_location,start_time
	 * @return List<Route>
	 */
	public List<Route> findByUserIdAndPayStatus(String start_location,String end_location,String start_time);
}
