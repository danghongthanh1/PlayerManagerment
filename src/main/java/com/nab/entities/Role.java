//package com.nab.entities;
//
//import java.io.Serializable;
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="ROLE")
//public class Role implements Serializable {
//	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="r_id")
//	private long id;
//	@Column(name="r_name")
//	private String name;
//	@OneToMany(fetch=FetchType.LAZY,mappedBy="ROlE")
//	private Set<UsersRoles> usersRoleses=new HashSet<UsersRoles>(0);
//	public Role() {
//	}
//	public Role(String name, Set<UsersRoles> usersRoleses) {
//		this.name = name;
//		this.usersRoleses = usersRoleses;
//	}
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public Set<UsersRoles> getUsersRoleses() {
//		return usersRoleses;
//	}
//	public void setUsersRoleses(Set<UsersRoles> usersRoleses) {
//		this.usersRoleses = usersRoleses;
//	}
//}
