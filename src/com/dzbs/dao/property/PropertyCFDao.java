package com.dzbs.dao.property;

import java.util.List;

import com.dzbs.bean.common.PropertyCF;

public interface PropertyCFDao {

	public void savePropertyCF(PropertyCF propertyCF);
	
	public void updatePropertyCF(PropertyCF propertyCF);
	
	public void deletePropertyCF(PropertyCF propertyCF);
	
	/**
	 * 用id进行查询
	 * @param id
	 * @return List<PropertyCF>
	 */
	public List<PropertyCF> findById(Integer id);
	
	/**
	 * 用property_id进行查询
	 * @param property_id
	 * @return List<PropertyCF>
	 */
	public List<PropertyCF> findByPropertyId(Integer property_id);
	
	/**
	 * 用member_id进行查询
	 * @param member_id
	 * @return List<PropertyCF>
	 */
	public List<PropertyCF> findByMemberId(Integer member_id);
	
	/**
	 * 用member_id,property_id进行查询
	 * @param member_id,property_id
	 * @return List<PropertyCF>
	 */
	public List<PropertyCF> findByMemberIdAndPropertyId(Integer member_id,Integer property_id);
}
