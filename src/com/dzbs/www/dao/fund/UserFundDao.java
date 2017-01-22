package com.dzbs.www.dao.fund;

import java.util.List;

import com.dzbs.www.bean.common.UserFund;

public interface UserFundDao{
	
	public void saveUserFund(UserFund userFund);
	
	public void updateUserFund(UserFund userFund);
	
	public void deleteUserFund(UserFund userFund);
	
	/**
	 * 用id进行查询
	 * @param id
	 * @return List<UserFund>
	 */
	public List<UserFund> findById(Integer id);
	
	/**
	 * 用user_id进行查询(乘客ID)
	 * @param user_id
	 * @return List<UserFund>
	 */
	public List<UserFund> findByUserId(Integer user_id);
}
