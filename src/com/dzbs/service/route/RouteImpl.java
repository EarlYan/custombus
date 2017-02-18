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
				" m.username,"+
				" m.mobile,"+
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
		Query query=this.sessionFactory.getCurrentSession().createQuery(sql)
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
				" m.username,"+
				" m.mobile,"+
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
		Query query=this.sessionFactory.getCurrentSession().createQuery(sql)
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
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Route as a WHERE a.deleted = false AND a.start_location like :start_location AND a.end_location like :end_location");
		query.setString("start_location","%"+start_location+"%");
		query.setString("end_location","%"+end_location+"%");
		@SuppressWarnings("unchecked")
		List<Route> temp = query.list();
		return temp;
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
}
