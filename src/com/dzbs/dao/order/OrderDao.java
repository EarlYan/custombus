package com.dzbs.dao.order;

import java.util.List;

import com.dzbs.bean.common.Order;

public interface OrderDao{
	
	public void saveOrder(Order order);
	
	public void updateOrder(Order order);
	
	public void deleteOrder(Order order);
	
	/**
	 * 用id进行查询
	 * @param id
	 * @return List<Order>
	 */
	public List<Order> findById(Integer id);
	
	/**
	 * 查询所有订单
	 * @return List<Order>
	 */
	public List<Order> findAllComments();
	
	/**
	 * 用user_id进行查询(乘客查询)
	 * @param user_id
	 * @return List<Order>
	 */
	public List<Order> findByUserId(Integer user_id);
	
	/**
	 * 用user_id进行查询(乘客支付状态查询)
	 * @param user_id,payed
	 * @return List<Order>
	 */
	public List<Order> findByUserIdAndPayStatus(Integer user_id,boolean payed);
	
	/**
	 * 用driver_id进行查询(司机查询)
	 * @param driver_id
	 * @return List<Order>
	 */
	public List<Order> findByDriverId(Integer driver_id);
}
