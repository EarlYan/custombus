package com.dzbs.service.license;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dzbs.bean.common.License;
import com.dzbs.dao.license.LicenseDao;

@Repository("licenseDao")
@Transactional(propagation = Propagation.REQUIRED)
public class LicenseService implements LicenseDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveLicense(License license) {
		sessionFactory.getCurrentSession().saveOrUpdate(license);
	}

	public void updateLicense(License license) {
		sessionFactory.getCurrentSession().update(license);
		sessionFactory.getCurrentSession().flush();
	}
	
	public void deleteLicense(License license) {
		sessionFactory.getCurrentSession().delete(license);
		sessionFactory.getCurrentSession().flush();
	}
	
	/**
	 * 用id进行查询
	 * @param id
	 * @return List<License>
	 */
	public List<License> findById(Integer id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM License WHERE deleted = false AND id = :id");
		query.setInteger("id", id);
		@SuppressWarnings("unchecked")
		List<License> temp = query.list();
		return temp;
	}
	
	/**
	 * 查询所有执照
	 * @return List<License>
	 */
	public List<License> findAllRoutes(){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM License WHERE deleted = false");
		@SuppressWarnings("unchecked")
		List<License> temp = query.list();
		return temp;
	}
	
	/**
	 * 用member_id进行查询(司机ID)
	 * @param member_id
	 * @return List<License>
	 */
	public List<License> findByMemberId(Integer member_id){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM License WHERE deleted = false AND member_id = :member_id");
		query.setInteger("member_id", member_id);
		@SuppressWarnings("unchecked")
		List<License> temp = query.list();
		return temp;
	}
	
	/**
	 * 用serial_number进行查询(驾驶证编号)
	 * @param serial_number
	 * @return List<License>
	 */
	public List<License> findBySerialNumber(String serial_number){
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM License WHERE deleted = false AND serial_number = :serial_number");
		query.setString("serial_number", serial_number);
		@SuppressWarnings("unchecked")
		List<License> temp = query.list();
		return temp;
	}
}
