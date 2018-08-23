//package com.nab.dao;
//
//import java.util.List;
//
//import javax.persistence.Query;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//@Repository
//@Transactional(rollbackFor = Exception.class)
//public class AuthorizationsDAO {
//	@Autowired
//	private SessionFactory sessionFactory;
//
//	public List<String> loadUrl(String role) {
//		Session session = sessionFactory.getCurrentSession();
//		Query query = session.createQuery("from Authorizations where RId=?").setParameter(0, role);
//		List<String> list=query.getResultList();
//		return list;
//	}
//}
