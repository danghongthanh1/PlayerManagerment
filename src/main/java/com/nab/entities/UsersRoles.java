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
//@Table(name="USER_ROLES")
//public class UsersRoles {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="ur_id",unique=true)
//	private long id;
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="ROLE")
//	private Role role;
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="USERS")
//	private User users;
//	public UsersRoles() {
//	}
//	public UsersRoles(Role role, User users) {
//		this.role = role;
//		this.users = users;
//	}
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
//	public Role getRole() {
//		return role;
//	}
//	public void setRole(Role role) {
//		this.role = role;
//	}
//	public User getUsers() {
//		return users;
//	}
//	public void setUsers(User users) {
//		this.users = users;
//	}
//	
//}
