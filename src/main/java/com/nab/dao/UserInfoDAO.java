//package com.nab.dao;
//
//
//import org.hibernate.Criteria;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.criterion.Restrictions;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.nab.entities.Person;
//import com.nab.entities.User;
//
//@Repository
//public class UserInfoDAO {
////	SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
//	@Autowired
//	private SessionFactory sessionFactory;
//	public User findUserInfor (String username) {
//		Session session=sessionFactory.openSession();
//		Criteria criteria = session.createCriteria(User.class).add(Restrictions.like("userName",username));
////		String hql="from UserInfo u Where u.userName="+username;
////		Query query =session.createQuery(hql);
////		return (UserInfo) query.uniqueResult();
//		return (User) criteria.uniqueResult();
//	}
//}
