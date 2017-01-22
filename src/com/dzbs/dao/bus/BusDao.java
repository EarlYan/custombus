package com.dzbs.dao.bus;

import java.util.List;

import com.dzbs.bean.common.Bus;

public interface BusDao{
	
public void saveBus(Bus bus);
	
	public void updateBus(Bus bus);
	
	public void deleteBus(Bus bus);
	
	/**
	 * 用id进行查询
	 * @param id
	 * @return List<Bus>
	 */
	public List<Bus> findById(Integer id);
	
	/**
	 * 查询所有巴士
	 * @return List<Bus>
	 */
	public List<Bus> findAllBuses();
	
	/**
	 * 用member_id进行查询(司机Id查询)
	 * @param member_id
	 * @return List<Bus>
	 */
	public List<Bus> findByMemberId(Integer member_id);
	
	/**
	 * 用plate_number进行查询(车牌号查询)
	 * @param plate_number
	 * @return List<Bus>
	 */
	public List<Bus> findByPlateNumber(String plate_number);
	
	/**
	 * 用bus_type进行查询(车型查询)
	 * @param bus_type
	 * @return List<Bus>
	 */
	public List<Bus> findByBusType(Integer bus_type);
}
