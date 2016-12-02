package com.dzbs.www.dao.bus;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dzbs.www.bean.common.Bus;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class BusDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveBus(Bus bus) {
		sessionFactory.getCurrentSession().saveOrUpdate(bus);
	}

	public void updateBus(Bus bus) {
		sessionFactory.getCurrentSession().update(bus);
		sessionFactory.getCurrentSession().flush();
	}
	
	public void deleteBus(Bus bus) {
		sessionFactory.getCurrentSession().delete(bus);
		sessionFactory.getCurrentSession().flush();
	}
	
	/**
	 * 用id进行查询
	 * @param id
	 * @return List<Bus>
	 */
	public List<Bus> findById(Integer id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Bus WHERE deleted = false AND id = :id");
		query.setInteger("id", id);
		@SuppressWarnings("unchecked")
		List<Bus> temp = query.list();
		return temp;
	}
	
	/**
	 * 查询所有巴士
	 * @return List<Bus>
	 */
	public List<Bus> findAllBuses(){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Bus WHERE deleted = false");
		@SuppressWarnings("unchecked")
		List<Bus> temp = query.list();
		return temp;
	}
	
	/**
	 * 用member_id进行查询(司机Id查询)
	 * @param member_id
	 * @return List<Bus>
	 */
	public List<Bus> findByMemberId(Integer member_id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Bus WHERE deleted = false AND member_id = :member_id");
		query.setInteger("member_id", member_id);
		@SuppressWarnings("unchecked")
		List<Bus> temp = query.list();
		return temp;
	}
	
	/**
	 * 用plate_number进行查询(车牌号查询)
	 * @param plate_number
	 * @return List<Bus>
	 */
	public List<Bus> findByPlateNumber(String plate_number){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Bus WHERE deleted = false AND plate_number = :plate_number");
		query.setString("plate_number", plate_number);
		@SuppressWarnings("unchecked")
		List<Bus> temp = query.list();
		return temp;
	}
	
	/**
	 * 用bus_type进行查询(车型查询)
	 * @param bus_type
	 * @return List<Bus>
	 */
	public List<Bus> findByBusType(Integer bus_type){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Bus WHERE deleted = false AND bus_type = :bus_type");
		query.setInteger("bus_type", bus_type);
		@SuppressWarnings("unchecked")
		List<Bus> temp = query.list();
		return temp;
	}
}
