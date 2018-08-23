package com.nab.entities;
// Generated Aug 23, 2018 10:38:45 AM by Hibernate Tools 5.2.11.Final

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "USERS", schema = "dbo", catalog = "CauLacBo", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5907692320208522334L;
	private Integer UId;
	private String username;
	private String password;
	private Boolean enable;
	private Set<UsersRoles> usersRoleses = new HashSet<UsersRoles>(0);

	public User() {
	}

	public User(String username, String password, Boolean enable, Set<UsersRoles> usersRoleses) {
		this.username = username;
		this.password = password;
		this.enable = enable;
		this.usersRoleses = usersRoleses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "u_id", unique = true, nullable = false)
	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

	@Column(name = "username", unique = true, length = 60)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enable")
	public Boolean getEnable() {
		return this.enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade=CascadeType.ALL)
	public Set<UsersRoles> getUsersRoleses() {
		return this.usersRoleses;
	}

	public void setUsersRoleses(Set<UsersRoles> usersRoleses) {
		this.usersRoleses = usersRoleses;
	}
	@Transient
	  public List<GrantedAuthority> getAuthorities() {
	    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	    for (UsersRoles usersRoles: this.usersRoleses) {
	      authorities.add(new SimpleGrantedAuthority(usersRoles.getRole().getRName()));
	    }
	    return authorities;
	  }

}
