package com.dzbs.www.service.license;

import java.util.List;

import com.dzbs.www.bean.common.License;

public interface LicenseService {

	public void saveLicense(License license);
	
	public void updateLicense(License license);
	
	public void deleteLicense(License license);
	
	/**
	 * 用id进行查询
	 * @param id
	 * @return List<License>
	 */
	public List<License> findById(Integer id);
	
	/**
	 * 查询所有执照
	 * @return List<License>
	 */
	public List<License> findAllRoutes();
	
	/**
	 * 用member_id进行查询(司机ID)
	 * @param member_id
	 * @return List<License>
	 */
	public List<License> findByMemberId(Integer member_id);
	
	/**
	 * 用serial_number进行查询(驾驶证编号)
	 * @param serial_number
	 * @return List<License>
	 */
	public List<License> findBySerialNumber(String serial_number);
}
