package com.dzbs.service.route;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dzbs.bean.common.Route;
import com.dzbs.bean.common.RouteVO;
import com.dzbs.dao.route.RouteDao;

@Repository("routeDao")
@Transactional(propagation = Propagation.REQUIRED)
public class RouteImpl implements RouteDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveRoute(Route route) {
		sessionFactory.getCurrentSession().saveOrUpdate(route);
	}

	@Override
	public void updateRoute(Route route) {
		sessionFactory.getCurrentSession().update(route);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void deleteRoute(Route route) {
		sessionFactory.getCurrentSession().delete(route);
		sessionFactory.getCurrentSession().flush();
	}
	
	/**
	 * 用id进行查询
	 * @param id
	 * @return List<Route>
	 */
	@Override
	public List<Route> findById(Integer id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Route WHERE deleted = false AND id = :id");
		query.setInteger("id", id);
		@SuppressWarnings("unchecked")
		List<Route> temp = query.list();
		return temp;
	}
	
	/**
	 * 用driverid进行查询
	 * @param id
	 * @return List<Route>
	 */
	@Override
	public List<Route> findByDriverId(Integer member_id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Route WHERE deleted = false AND member_id = :member_id");
		query.setInteger("member_id", member_id);
		@SuppressWarnings("unchecked")
		List<Route> temp = query.list();
		return temp;
	}
	
	/**
	 * 用driverid进行查询
	 * @return List<RouteVO>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RouteVO> findByDriverIdVO(Integer member_id){
		String sql = "SELECT"+
				" m.username as 'd_username',"+
				" m.mobile as 'd_mobile',"+
				" b.plate_number,"+
				" b.bus_type,"+
				" t.start_location,"+
				" t.end_location,"+
				" t.start_time,"+
				" t.mileage,"+
				" t.about_time,"+
				" t.isFull,"+
				" t.id"+
			" FROM"+
				" t_bus b,"+
				" t_member m,"+
				" t_route t"+
			 " WHERE"+
				" t.member_id = m.id"+
			 " AND t.bus_id = b.id"+
			 " AND t.deleted = 0"+
			 " AND t.member_id = :member_id";
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.setResultTransformer(Transformers.aliasToBean(RouteVO.class));
		query.setInteger("member_id", member_id);
		return query.list();
	}
	
	/**
	 * 用driverid进行分页查询
	 * @return List<RouteVO>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RouteVO> findByDriverIdVO(Integer pageNo,Integer pageSize,Integer member_id){
		String sql = "SELECT"+
				" m.username as 'd_username',"+
				" m.mobile as 'd_mobile',"+
				" b.plate_number,"+
				" b.bus_type,"+
				" t.start_location,"+
				" t.end_location,"+
				" t.start_time,"+
				" t.mileage,"+
				" t.about_time,"+
				" t.isFull,"+
				" t.id"+
			" FROM"+
				" t_bus b,"+
				" t_member m,"+
				" t_route t"+
			 " WHERE"+
				" t.member_id = m.id"+
			 " AND t.bus_id = b.id"+
			 " AND t.deleted = 0"+
			 " AND t.member_id = :member_id";
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.setResultTransformer(Transformers.aliasToBean(RouteVO.class));
		query.setInteger("member_id", member_id);
		if(pageSize != -1 && pageNo != -1) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		return query.list();
	}
	
	/**
	 * 查询所有线路
	 * @return List<Route>
	 */
	@Override
	public List<Route> findAllRoutes(){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Route WHERE deleted = false");
		@SuppressWarnings("unchecked")
		List<Route> temp = query.list();
		return temp;
	}
	
	/**
	 * 查询所有线路
	 * @return List<RouteVO>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RouteVO> findAllRoutesVO(){
		String sql = "SELECT"+
				" m.username as 'd_username',"+
				" m.mobile as 'd_mobile',"+
				" b.plate_number,"+
				" b.bus_type,"+
				" t.start_location,"+
				" t.end_location,"+
				" t.start_time,"+
				" t.mileage,"+
				" t.about_time,"+
				" t.isFull,"+
				" t.id"+
			" FROM"+
				" t_bus b,"+
				" t_member m,"+
				" t_route t"+
			 " WHERE"+
				" t.member_id = m.id"+
			 " AND t.bus_id = b.id"+
			 " AND t.deleted = 0";
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.setResultTransformer(Transformers.aliasToBean(RouteVO.class));
		return query.list();
	}
	
	/**
	 * 查询所有线路
	 * @return List<RouteVO>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RouteVO> findAllRoutesVO(Integer pageNo,Integer pageSize){
		String sql = "SELECT"+
				" m.username as 'd_username',"+
				" m.mobile as 'd_mobile',"+
				" b.plate_number,"+
				" b.bus_type,"+
				" t.start_location,"+
				" t.end_location,"+
				" t.start_time,"+
				" t.mileage,"+
				" t.about_time,"+
				" t.isFull,"+
				" t.id"+
			" FROM"+
				" t_bus b,"+
				" t_member m,"+
				" t_route t"+
			 " WHERE"+
				" t.member_id = m.id"+
			 " AND t.bus_id = b.id"+
			 " AND t.deleted = 0";
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.setResultTransformer(Transformers.aliasToBean(RouteVO.class));
		if(pageSize != -1 && pageNo != -1) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		return query.list();
	}
	
	/**
	 * 用start_location,end_location进行查询(起终点查询)
	 * @param start_location,end_location
	 * @return List<Route>
	 */
	@Override
	public List<Route> findByStartAndEndLocation(String start_location,String end_location){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Route as a WHERE a.deleted = false AND a.start_location like :start_location AND a.end_location like :end_location AND a.full = :false");
		query.setString("start_location","%"+start_location+"%");
		query.setString("end_location","%"+end_location+"%");
		@SuppressWarnings("unchecked")
		List<Route> temp = query.list();
		return temp;
	}
	
	/**
	 * 用start_location,end_location进行查询(起终点查询)
	 * @param start_location,end_location
	 * @return List<RouteVO>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RouteVO> findByStartAndEndLocationVO(String start_location,String end_location){
		String sql = "SELECT"+
				" m.username as 'd_username',"+
				" m.mobile as 'd_mobile',"+
				" b.plate_number,"+
				" b.bus_type,"+
				" t.start_location,"+
				" t.end_location,"+
				" t.start_time,"+
				" t.mileage,"+
				" t.about_time,"+
				" t.isFull,"+
				" t.id"+
			" FROM"+
				" t_bus b,"+
				" t_member m,"+
				" t_route t"+
			 " WHERE"+
				" t.member_id = m.id"+
			 " AND t.bus_id = b.id"+
			 " AND t.deleted = 0"+
			 " AND t.isFull = 0"+
			 " AND t.start_location like :start_location"+
			 " AND t.end_location like :end_location";
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.setResultTransformer(Transformers.aliasToBean(RouteVO.class));
		query.setString("start_location","%"+start_location+"%");
		query.setString("end_location","%"+end_location+"%");
		return query.list();
	}
	
	/**
	 * 用start_location,end_location,start_time进行查询(起终点时间查询)
	 * @param start_location,end_location,start_time
	 * @return List<Route>
	 */
	@Override
	public List<Route> findByStartEndTimeAndNotFull(String start_location,String end_location,String start_time){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Route as a WHERE a.deleted = false AND a.start_location like :start_location AND a.end_location like :end_location AND a.start_time like :start_time AND a.full = :false");
		query.setString("start_location","%"+start_location+"%");
		query.setString("end_location","%"+end_location+"%");
		query.setString("start_time", "%"+start_time+"%");
		@SuppressWarnings("unchecked")
		List<Route> temp = query.list();
		return temp;
	}
	
	/**
	 * 用start_location,end_location,start_time进行查询(起终点时间查询)
	 * @param start_location,end_location,start_time
	 * @return List<RouteVO>
	 */
	@SuppressWarnings("unchecked")
	public List<RouteVO> findByStartEndTimeAndNotFullVO(String start_location,String end_location,String start_time){
		String temp = start_time.substring(0,2);//截取小时
		int hour = Integer.valueOf(temp);
		String query_time_start = "";
		String query_time_end = "";
		if(hour >0 && hour <12){
			query_time_start = "'1970-01-01 05:00:00'";
			query_time_end = "'1970-01-01 12:00:00'";	
		}else{
			query_time_start = "'1970-01-01 12:00:00'";
			query_time_end = "'1970-01-01 24:00:00'";	
		}			
		String sql = "SELECT"+
				" m.username as 'd_username',"+
				" m.mobile as 'd_mobile',"+
				" b.plate_number,"+
				" b.bus_type,"+
				" t.start_location,"+
				" t.end_location,"+
				" t.start_time,"+
				" t.mileage,"+
				" t.about_time,"+
				" t.isFull,"+
				" t.id"+
			" FROM"+
				" t_bus b,"+
				" t_member m,"+
				" t_route t"+
			 " WHERE"+
				" t.member_id = m.id"+
			 " AND t.bus_id = b.id"+
			 " AND t.deleted = 0"+
			 " AND t.isFull = 0"+
			 " AND t.start_location like :start_location"+
			 " AND t.end_location like :end_location"+
			 " AND t.start_time between "+query_time_start+" AND "+query_time_end;
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.setResultTransformer(Transformers.aliasToBean(RouteVO.class));
		query.setString("start_location","%"+start_location+"%");
		query.setString("end_location","%"+end_location+"%");
		return query.list();
	}
	
	/**
	 * 用start_location,end_location,start_time进行查询(起终点时间查询)
	 * @param start_location,end_location,start_time
	 * @return List<RouteVO>
	 */
	@SuppressWarnings("unchecked")
	public List<RouteVO> findByStartEndTimeBusTypeAndNotFullVO(String start_location,String end_location,String start_time,Integer bus_type){
		String temp = start_time.substring(0,2);//截取小时
		int hour = Integer.valueOf(temp);
		int nextHour= hour+1;
		String query_time_start = "'1970-01-01 "+hour+":00:00'";
		String query_time_end = "'1970-01-01 "+nextHour+":00:00'";		
		String sql = "SELECT"+
				" m.username as 'd_username',"+
				" m.mobile as 'd_mobile',"+
				" b.plate_number,"+
				" b.bus_type,"+
				" t.start_location,"+
				" t.end_location,"+
				" t.start_time,"+
				" t.mileage,"+
				" t.about_time,"+
				" t.isFull,"+
				" t.id"+
			" FROM"+
				" t_bus b,"+
				" t_member m,"+
				" t_route t"+
			 " WHERE"+
				" t.member_id = m.id"+
			 " AND t.bus_id = b.id"+
			 " AND t.deleted = 0"+
			 " AND t.isFull = 0"+
			 " AND t.start_location like :start_location"+
			 " AND t.end_location like :end_location"+
			 " AND b.bus_type = :bus_type"+
			 " AND t.start_time between "+query_time_start+" AND "+query_time_end;		
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery(sql)
				.setResultTransformer(Transformers.aliasToBean(RouteVO.class));
		query.setString("start_location","%"+start_location+"%");
		query.setString("end_location","%"+end_location+"%");
		query.setInteger("bus_type", bus_type);
		return query.list();
	}
}
