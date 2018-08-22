package com.nab.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FINANCE")
public class Finance {
	@Id
	@Column(name = "fid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_finance;
	@Column(name="ftype")
	private String typefinance;
	@Column(name="pid",nullable=true)
	private long id_person;
	@Column(name="description")
	private String description;
	@Column(name="money")
	float money;
	public long getId_finance() {
		return id_finance;
	}
	public void setId_finance(long id_finance) {
		this.id_finance = id_finance;
	}
	public String getTypefinance() {
		return typefinance;
	}
	public void setTypefinance(String typefinance) {
		this.typefinance = typefinance;
	}
	public long getId_person() {
		return id_person;
	}
	public void setId_person(long row) {
		this.id_person = row;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public Finance() {
		
	}
	public Finance(String typefinance, long id_person, String description, float money) {
		this.typefinance = typefinance;
		this.id_person = id_person;
		this.description = description;
		this.money = money;
	}
}
