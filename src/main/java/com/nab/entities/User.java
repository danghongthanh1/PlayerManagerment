//package com.nab.entities;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
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
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//@Entity
//@Table(name = "USERS")
//public class User implements Serializable {
//	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//
//	@Column(name = "u_id")
//	private long id;
//	@Column(name = "username")
//	private String userName;
//	@Column(name = "password")
//	private String password;
//	@Column(name = "enable")
//	private Boolean enabled;
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "USERS")
//	private Set<UsersRoles> usersRoleses = new HashSet<UsersRoles>(0);
//
//	public User() {
//
//	}
//
//	public User(String userName, String password, Boolean enabled, Set<UsersRoles> usersRoleses) {
//		super();
//		this.userName = userName;
//		this.password = password;
//		this.enabled = enabled;
//		this.usersRoleses = usersRoleses;
//	}
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public Boolean getEnabled() {
//		return enabled;
//	}
//
//	public void setEnabled(Boolean enabled) {
//		this.enabled = enabled;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public Set<UsersRoles> getUsersRoleses() {
//		return this.usersRoleses;
//	}
//
//	public List<GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
//		for(UsersRoles usersRoles: this.usersRoleses) {
//			authorities.add(new SimpleGrantedAuthority(usersRoles.getRole().getName()));
//			return authorities;
//		}
//		return null;
//	}
//}
