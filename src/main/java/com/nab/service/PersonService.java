package com.nab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nab.dao.PersonDAO;
import com.nab.entities.Person;
@Service
public class PersonService {
	@Autowired
	private PersonDAO personDAO;
	public void save(Person persion) {
		personDAO.save(persion);
	}
	public void update(Person persion) {
		personDAO.update(persion);
	}
	public void delete(int id) {
		personDAO.delete(id);
	}
	public Person findById(long id) {
		return personDAO.findById(id);
	}
	public List<Person> getAll(){
		return personDAO.getAll();
	}
	public List<Person> getPersons(int position,int pageSize){
		return personDAO.getPersons( position, pageSize);
	}
	public long countTotalRecord() {
		return personDAO.countTotalRecords();
	}
	public List<Person> searchPersons(String name, int page, int pageSize) {
		return personDAO.searchPersons(name,page,pageSize);
	}
	public long countTotalRecord(String name) {
		return personDAO.countTotalRecords(name);
	}
	
}
