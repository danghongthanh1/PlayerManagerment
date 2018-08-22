package com.nab.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserRoleDAO {
//	private SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
	@Autowired
	private SessionFactory sessionFactory;
	public List<String> getUserRoles(String userName){
		Session session=sessionFactory.openSession();
		String hql="Select u.userRole from UserRole u Where u.userName like '"+userName+"'";
		Query query=session.createQuery(hql);
		List<String> list=query.getResultList();
		return list;
	}
}
