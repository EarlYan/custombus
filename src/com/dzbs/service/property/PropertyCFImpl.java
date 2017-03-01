package com.dzbs.service.property;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dzbs.bean.common.PropertyCF;
import com.dzbs.dao.property.PropertyCFDao;

@Repository("propertyCFDao")
@Transactional(propagation = Propagation.REQUIRED)
public class PropertyCFImpl implements PropertyCFDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void savePropertyCF(PropertyCF propertyCF) {
		sessionFactory.getCurrentSession().saveOrUpdate(propertyCF);
	}

	@Override
	public void updatePropertyCF(PropertyCF propertyCF) {
		sessionFactory.getCurrentSession().update(propertyCF);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deletePropertyCF(PropertyCF propertyCF) {
		sessionFactory.getCurrentSession().delete(propertyCF);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public List<PropertyCF> findById(Integer id) {
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM PropertyCF WHERE deleted = false AND id = :id");
		query.setInteger("id", id);
		@SuppressWarnings("unchecked")
		List<PropertyCF> temp = query.list();
		return temp;
	}

	@Override
	public List<PropertyCF> findByPropertyId(Integer property_id) {
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM PropertyCF WHERE deleted = false AND property_id = :property_id");
		query.setInteger("property_id", property_id);
		@SuppressWarnings("unchecked")
		List<PropertyCF> temp = query.list();
		return temp;
	}

	@Override
	public List<PropertyCF> findByMemberId(Integer member_id) {
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM PropertyCF WHERE deleted = false AND member_id = :member_id");
		query.setInteger("member_id", member_id);
		@SuppressWarnings("unchecked")
		List<PropertyCF> temp = query.list();
		return temp;
	}

	@Override
	public List<PropertyCF> findByMemberIdAndPropertyId(Integer member_id,Integer property_id) {
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM PropertyCF WHERE deleted = false AND member_id = :member_id AND property_id = :property_id");
		query.setInteger("member_id", member_id);
		query.setInteger("property_id", property_id);
		@SuppressWarnings("unchecked")
		List<PropertyCF> temp = query.list();
		return temp;
	}
}
