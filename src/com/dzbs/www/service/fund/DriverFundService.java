package com.dzbs.www.service.fund;

import java.util.List;

import com.dzbs.www.bean.common.DriverFund;

public interface DriverFundService {

	public void saveDriverFund(DriverFund driverFund);
	
	public void updateDriverFund(DriverFund driverFund);
	
	public void deleteDriverFund(DriverFund driverFund);
	
	/**
	 * 用id进行查询
	 * @param id
	 * @return List<DriverFund>
	 */
	public List<DriverFund> findById(Integer id);
	
	/**
	 * 用driver_id进行查询(司机ID)
	 * @param driver_id
	 * @return List<DriverFund>
	 */
	public List<DriverFund> findByDriverId(Integer driver_id);
}
