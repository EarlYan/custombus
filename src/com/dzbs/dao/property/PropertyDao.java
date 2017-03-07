package com.dzbs.dao.property;

import java.util.List;

import com.dzbs.bean.common.Property;
import com.dzbs.bean.common.PropertyVO;

public interface PropertyDao {

	public void saveProperty(Property property);
	
	public void updateProperty(Property property);
	
	public void deleteProperty(Property property);
	
	/**
	 * 用id进行查询
	 * @param id
	 * @return List<Property>
	 */
	public List<Property> findById(Integer id);
	
	/**
	 * 查询所有众筹
	 * @return List<Property>
	 */
	public List<Property> findAllProperties();
	
	/**
	 * 查询所有众筹
	 * @return List<Property>
	 */
	public List<Property> findAllProperties(Integer pageNo,Integer pageSize);
	
	/**
	 * 查询所有众筹
	 * @return List<PropertyVO>
	 */
	public List<PropertyVO> findAllPropertiesVO();
	
	/**
	 * 查询所有众筹
	 * @return List<PropertyVO>
	 */
	public List<PropertyVO> findAllPropertiesVO(Integer pageNo,Integer pageSize);
	
	/**
	 * 通过位置查询众筹信息
	 * @return List<Property>
	 */
	public List<Property> findPropertiesByLocation(String startLocation,String endLocation);
	
	/**
	 * 最新众筹信息
	 * @return List<Property>
	 */
	public List<Property> findLatestProperties();
}
