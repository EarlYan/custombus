package com.dzbs.service.fund;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dzbs.bean.common.DriverFund;
import com.dzbs.dao.fund.DriverFundDao;

@Repository("driverFundDao")
@Transactional(propagation = Propagation.REQUIRED)
public class DriverFundImpl implements DriverFundDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveDriverFund(DriverFund driverFund) {
		sessionFactory.getCurrentSession().saveOrUpdate(driverFund);
	}

	@Override
	public void updateDriverFund(DriverFund driverFund) {
		sessionFactory.getCurrentSession().update(driverFund);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void deleteDriverFund(DriverFund driverFund) {
		sessionFactory.getCurrentSession().delete(driverFund);
		sessionFactory.getCurrentSession().flush();
	}
	
	/**
	 * 用id进行查询
	 * @param id
	 * @return List<DriverFund>
	 */
	@Override
	public List<DriverFund> findById(Integer id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM DriverFund WHERE deleted = false AND id = :id");
		query.setInteger("id", id);
		@SuppressWarnings("unchecked")
		List<DriverFund> temp = query.list();
		return temp;
	}
	
	/**
	 * 用driver_id进行查询(司机ID)
	 * @param driver_id
	 * @return List<DriverFund>
	 */
	@Override
	public List<DriverFund> findByDriverId(Integer driver_id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM DriverFund WHERE deleted = false AND driver_id = :driver_id");
		query.setInteger("driver_id", driver_id);
		@SuppressWarnings("unchecked")
		List<DriverFund> temp = query.list();
		return temp;
	}
}
