package com.nab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nab.dao.FinanceDAO;
import com.nab.entities.Finance;

@Service
public class FinanceService {
	@Autowired
	private FinanceDAO financeDAO;
	public void save(Finance finance) {
		financeDAO.save(finance);
	}
	public void update(Finance finance) {
		financeDAO.update(finance);
	}
	public void delete(int id) {
		financeDAO.delete(id);
	}
	public Finance findById(long id) {
		return financeDAO.findById(id);
	}
	public List<Finance> getAll(){
		List<Finance> list=financeDAO.getAll();
		return list;
	}
	public List<Finance> getFinances(String finance_type) {
		List<Finance> list=financeDAO.getFinances(finance_type);
		return list;
	}
}
