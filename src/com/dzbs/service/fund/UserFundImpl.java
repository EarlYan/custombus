package com.dzbs.service.fund;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dzbs.bean.common.UserFund;
import com.dzbs.dao.fund.UserFundDao;

@Repository("userFundDao")
@Transactional(propagation = Propagation.REQUIRED)
public class UserFundImpl implements UserFundDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveUserFund(UserFund userFund) {
		sessionFactory.getCurrentSession().saveOrUpdate(userFund);
	}

	@Override
	public void updateUserFund(UserFund userFund) {
		sessionFactory.getCurrentSession().update(userFund);
		sessionFactory.getCurrentSession().flush();
	}
	
	@Override
	public void deleteUserFund(UserFund userFund) {
		sessionFactory.getCurrentSession().delete(userFund);
		sessionFactory.getCurrentSession().flush();
	}
	
	/**
	 * 用id进行查询
	 * @param id
	 * @return List<UserFund>
	 */
	@Override
	public List<UserFund> findById(Integer id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM UserFund WHERE deleted = false AND id = :id");
		query.setInteger("id", id);
		@SuppressWarnings("unchecked")
		List<UserFund> temp = query.list();
		return temp;
	}
	
	/**
	 * 用user_id进行查询(乘客ID)
	 * @param user_id
	 * @return List<UserFund>
	 */
	@Override
	public List<UserFund> findByUserId(Integer user_id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM UserFund WHERE deleted = false AND user_id = :user_id");
		query.setInteger("user_id", user_id);
		@SuppressWarnings("unchecked")
		List<UserFund> temp = query.list();
		return temp;
	}
}
