package com.dzbs.service.order;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dzbs.bean.common.Order;
import com.dzbs.bean.common.OrderVO;
import com.dzbs.dao.order.OrderDao;

@Repository("orderDao")
@Transactional(propagation = Propagation.REQUIRED)
public class OrderImpl implements OrderDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveOrder(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
	}

	@Override
	public void updateOrder(Order order) {
		sessionFactory.getCurrentSession().update(order);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void deleteOrder(Order order) {
		sessionFactory.getCurrentSession().delete(order);
		sessionFactory.getCurrentSession().flush();
	}
	

	/**
	 * 用id进行查询
	 * @param id
	 * @return List<Order>
	 */
	@Override
	public List<Order> findById(Integer id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Order WHERE deleted = false AND id = :id");
		query.setInteger("id", id);
		@SuppressWarnings("unchecked")
		List<Order> temp = query.list();
		return temp;
	}
	
	/**
	 * 查询所有订单
	 * @return List<Order>
	 */
	@Override
	public List<Order> findAllOrders(){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Order WHERE deleted = false");
		@SuppressWarnings("unchecked")
		List<Order> temp = query.list();
		return temp;
	}
	
	/**
	 * 查询所有订单
	 * @return List<Order>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAllOrders(Integer pageNo,Integer pageSize){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Order WHERE deleted = false");
		if(pageSize != -1 && pageNo != -1) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		List<Order> temp = query.list();
		return temp;
	}
	
	/**
	 * 查询所有订单
	 * @return List<OrderVO>
	 */
	@Override
	public List<OrderVO> findAllOrdersVO(){
		String sql = "SELECT"+
						" m2.username as p_username,"+
						" m2.mobile as p_mobile,"+
						" o.id,"+
						" o.seat_id,"+
						" o.price,"+
						" o.pay_time,"+
						" b.plate_number,"+
						" r.start_location,"+
						" r.end_location,"+
						" r.start_time,"+
						" m.username as d_username,"+
						" m.mobile as d_mobile"+
					" FROM"+
						" t_order o,"+
						" t_bus b,"+
						" t_route r,"+
						" t_member m,"+
						" t_member m2"+
					" WHERE"+
						" o.route_id = r.id"+
					" AND o.bus_id = b.id"+
					" AND o.driver_id = m.id"+
					" AND o.user_id = m2.id";
		Query query=this.sessionFactory.getCurrentSession().
				createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(OrderVO.class));
		@SuppressWarnings("unchecked")
		List<OrderVO> temp = query.list();
		return temp;
	}
	
	/**
	 * 查询所有订单分页
	 * @return List<OrderVO>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderVO> findAllOrdersVO(Integer pageNo,Integer pageSize){
		String sql = "SELECT"+
						" m2.username as p_username,"+
						" m2.mobile as p_mobile,"+
						" o.id,"+
						" o.seat_id,"+
						" o.price,"+
						" o.pay_time,"+
						" b.plate_number,"+
						" r.start_location,"+
						" r.end_location,"+
						" r.start_time,"+
						" m.username as d_username,"+
						" m.mobile as d_mobile"+
					" FROM"+
						" t_order o,"+
						" t_bus b,"+
						" t_route r,"+
						" t_member m,"+
						" t_member m2"+
					" WHERE"+
						" o.route_id = r.id"+
					" AND o.bus_id = b.id"+
					" AND o.driver_id = m.id"+
					" AND o.user_id = m2.id";
		Query query=this.sessionFactory.getCurrentSession().
				createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(OrderVO.class));
		if(pageSize != -1 && pageNo != -1) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		List<OrderVO> temp = query.list();
		return temp;
	}
	/**
	 * 用user_id进行查询(乘客查询)
	 * @param user_id
	 * @return List<Order>
	 */
	@Override
	public List<Order> findByUserId(Integer user_id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Order WHERE deleted = false AND user_id = :user_id");
		query.setInteger("user_id", user_id);
		@SuppressWarnings("unchecked")
		List<Order> temp = query.list();
		return temp;
	}
	
	/**
	 * 用user_id进行查询(乘客查询)
	 * @return List<OrderVO>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderVO> findByUserIdVO(Integer user_id){
		String sql = "SELECT"+
						" m2.username as p_username,"+
						" m2.mobile as p_mobile,"+
						" o.id,"+
						" o.seat_id,"+
						" o.price,"+
						" o.pay_time,"+
						" b.plate_number,"+
						" r.start_location,"+
						" r.end_location,"+
						" r.start_time,"+
						" m.username as d_username,"+
						" m.mobile as d_mobile"+
					" FROM"+
						" t_order o,"+
						" t_bus b,"+
						" t_route r,"+
						" t_member m,"+
						" t_member m2"+
					" WHERE"+
						" o.route_id = r.id"+
					" AND o.bus_id = b.id"+
					" AND o.driver_id = m.id"+
					" AND o.user_id = m2.id"+
					" AND o.user_id = :user_id";
		Query query=this.sessionFactory.getCurrentSession().
				createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(OrderVO.class));
		query.setInteger("user_id", user_id);
		List<OrderVO> temp = query.list();
		return temp;
	}
	/**
	 * 用user_id进行查询(乘客查询)分页
	 * @param user_id
	 * @return List<Order>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findByUserId(Integer user_id,Integer pageNo,Integer pageSize){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Order WHERE deleted = false AND user_id = :user_id");
		query.setInteger("user_id", user_id);
		if(pageSize != -1 && pageNo != -1) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		List<Order> temp = query.list();
		return temp;
	}
	
	/**
	 * 用user_id进行查询(乘客支付状态查询)
	 * @param user_id,payed
	 * @return List<Order>
	 */
	@Override
	public List<Order> findByUserIdAndPayStatus(Integer user_id,boolean payed){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Order WHERE deleted = false AND user_id = :user_id And payed = :payed");
		query.setInteger("user_id", user_id);
		query.setBoolean("payed", payed);
		@SuppressWarnings("unchecked")
		List<Order> temp = query.list();
		return temp;
	}
	
	/**
	 * 用user_id进行查询(乘客查询)
	 * @return List<OrderVO>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderVO> findByUserIdVO(Integer user_id,Integer pageNo,Integer pageSize){
		String sql = "SELECT"+
						" m2.username as p_username,"+
						" m2.mobile as p_mobile,"+
						" o.id,"+
						" o.seat_id,"+
						" o.price,"+
						" o.pay_time,"+
						" b.plate_number,"+
						" r.start_location,"+
						" r.end_location,"+
						" r.start_time,"+
						" m.username as d_username,"+
						" m.mobile as d_mobile"+
					" FROM"+
						" t_order o,"+
						" t_bus b,"+
						" t_route r,"+
						" t_member m,"+
						" t_member m2"+
					" WHERE"+
						" o.route_id = r.id"+
					" AND o.bus_id = b.id"+
					" AND o.driver_id = m.id"+
					" AND o.user_id = m2.id"+
					" AND o.user_id = :user_id";
		Query query=this.sessionFactory.getCurrentSession().
				createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(OrderVO.class));
		query.setInteger("user_id", user_id);
		if(pageSize != -1 && pageNo != -1) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		List<OrderVO> temp = query.list();
		return temp;
	}
	
	/**
	 * 用driver_id进行查询(司机查询)
	 * @param driver_id
	 * @return List<Order>
	 */
	@Override
	public List<Order> findByDriverId(Integer driver_id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Order WHERE deleted = false AND driver_id = :driver_id");
		query.setInteger("driver_id", driver_id);
		@SuppressWarnings("unchecked")
		List<Order> temp = query.list();
		return temp;
	}
	
	/**
	 * 用driver_id进行查询(司机查询)
	 * @param driver_id
	 * @return List<Order>
	 */
	@Override
	public List<Order> findByRouteId(Integer route_id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Order WHERE deleted = false AND route_id = :route_id");
		query.setInteger("route_id", route_id);
		@SuppressWarnings("unchecked")
		List<Order> temp = query.list();
		return temp;
	}
}
