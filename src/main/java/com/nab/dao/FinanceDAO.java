package com.nab.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nab.entities.Finance;

@Repository
@Transactional(rollbackFor = Exception.class)
public class FinanceDAO {
	@Autowired
	private SessionFactory sessionFactory;
//	private SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();

	public void save(Finance finance) {
		Session session = sessionFactory.getCurrentSession();
		session.save(finance);
	}

	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Finance finance = (Finance) session.load(Finance.class, id);
		session.delete(finance);
	}

	public void update(Finance finance) {
		Session session = sessionFactory.getCurrentSession();
		session.update(finance);
	}

	public Finance findById(long id) {
		Session session = sessionFactory.getCurrentSession();
		Finance finance = session.load(Finance.class, id);
		return finance;
	}

	@SuppressWarnings({ "unchecked" })
	public List<Finance> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Finance");
		List<Finance> list =  query.getResultList();
		return list;
	}

	public List<Finance> getFinances(String finance_type) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Finance.class).add(Restrictions.like("typefinance", finance_type));
		return criteria.list();
	}
}
