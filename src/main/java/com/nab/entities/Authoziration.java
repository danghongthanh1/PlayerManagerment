//package com.nab.entities;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="AUTHOZIRATION")
//public class Authoziration {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	
//	@Column(name="a_id")
//	private long id;
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="ROLE")
//	private Role role;
//	@Column(name="url")
//	private String url;
//	public Authoziration() {
//	}
//	public Authoziration(Role role, String url) {
//		this.role = role;
//		this.url = url;
//	}
//	public Role getRole() {
//		return role;
//	}
//	public void setRole(Role role) {
//		this.role = role;
//	}
//	public String getUrl() {
//		return url;
//	}
//	public void setUrl(String url) {
//		this.url = url;
//	}
//}
