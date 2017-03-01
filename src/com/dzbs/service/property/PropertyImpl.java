package com.dzbs.service.property;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dzbs.bean.common.Property;
import com.dzbs.dao.property.PropertyDao;

@Repository("propertyDao")
@Transactional(propagation = Propagation.REQUIRED)
public class PropertyImpl implements PropertyDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveProperty(Property property) {
		sessionFactory.getCurrentSession().saveOrUpdate(property);
	}

	@Override
	public void updateProperty(Property property) {
		sessionFactory.getCurrentSession().update(property);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteProperty(Property property) {
		sessionFactory.getCurrentSession().delete(property);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public List<Property> findById(Integer id) {
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Property WHERE deleted = false AND id = :id");
		query.setInteger("id", id);
		@SuppressWarnings("unchecked")
		List<Property> temp = query.list();
		return temp;
	}

	@Override
	public List<Property> findAllProperties() {
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Property WHERE deleted = 0");
		@SuppressWarnings("unchecked")
		List<Property> temp = query.list();
		return temp;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Property> findAllProperties(Integer pageNo,Integer pageSize) {
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Property WHERE deleted = 0");
		if(pageSize != -1 && pageNo != -1) {
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		List<Property> temp = query.list();
		return temp;
	}

	@Override
	public List<Property> findPropertiesByLocation(String startLocation, String endLocation) {
		Query query=this.sessionFactory.getCurrentSession().createQuery("FROM Property WHERE deleted = false AND startLocation = :startLocation And endLocation = :endLocation");
		query.setString("startLocation", startLocation);
		query.setString("endLocation", endLocation);
		@SuppressWarnings("unchecked")
		List<Property> temp = query.list();
		return temp;
	}

	@Override
	public List<Property> findLatestProperties() {
		Query query=this.sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM t_property WHERE deleted = false order by id desc limit 6").setResultTransformer(Transformers.aliasToBean(Property.class));
		@SuppressWarnings("unchecked")
		List<Property> temp = query.list();
		return temp;
	}
}
