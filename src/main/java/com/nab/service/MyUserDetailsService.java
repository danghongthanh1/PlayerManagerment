//package com.nab.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.nab.dao.UserDAO;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService{
//	@Autowired
//	private UserDAO userDAO;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//		com.nab.entities.User user=userDAO.loadUserByUsername(username);
//		if(user==null) {
//			return null;
//		}
//		boolean accountNonExpired=true;
//		boolean credentialsNonExpired=true;
//		boolean accountNonlocked=true;
//		User userdetail=new User(username,user.getPassword(),user.getEnabled(),accountNonExpired,
//				credentialsNonExpired,accountNonlocked,user.getAuthorities());
//		return userdetail;
//	}
//}
