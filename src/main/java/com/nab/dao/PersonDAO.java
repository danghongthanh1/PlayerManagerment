package com.nab.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nab.entities.Person;

@Repository
@Transactional(rollbackFor = Exception.class)
public class PersonDAO {
	@Autowired
	private SessionFactory sessionFactory;
//	private SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
	public void save(Person person) {
		Session session = sessionFactory.getCurrentSession();
			session.save(person);
	}

	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		Person persion = (Person) session.load(Person.class, id);
		session.delete(persion);
	}

	public void update(Person person) {
		Session session = sessionFactory.getCurrentSession();
		session.update(person);
	}

	public Person findById(long id) {
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Person where id="+id);
		return (Person) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Person> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Person>list = session.createQuery("from Person").getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Person> getPersons(int position, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Person");
		query.setFirstResult(position);
		query.setMaxResults(pageSize);
		List<Person> list=query.getResultList();
		return list;
	}

	public long countTotalRecords() {
		Session session = sessionFactory.getCurrentSession();
		String SQL_QUERY = "SELECT COUNT(*) FROM Person person";
		Query query = session.createQuery(SQL_QUERY);
		Long result = (Long) query.uniqueResult();
		return result;
	}

	public long countTotalRecords(String name) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Person.class).add(Restrictions.like("name", name + "%"));
		long totalRow = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		return totalRow;
	}

	public List<Person> searchPersons(String name, int position, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Person.class).add(Restrictions.like("name", name + "%"));
		criteria.setFirstResult(position);
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}
}
