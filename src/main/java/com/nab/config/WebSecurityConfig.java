package com.nab.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.nab.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	MyUserDetailsService myUserDetailsService;
//	@Autowired
//	AuthorizationsDAO authorizationsDAO;
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// user in memory
		auth.inMemoryAuthentication().withUser("user").password("12345").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("12345").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("superadmin").password("12345").roles("SUPER_ADMIN");
		// user in database
		auth.userDetailsService(myUserDetailsService);
		// DaoAuthenticationProvider dd=new  DaoAuthenticationProvider;
	}

	protected void configure(HttpSecurity http) throws Exception {
//		List<String> UserUrl= authorizationsDAO.loadUrl("USER_ROLE");
//		List<String> AdminUrl= authorizationsDAO.loadUrl("ADMIN_ROLE");
//		List<String> SupperAdminUrl= authorizationsDAO.loadUrl("SUPER_ADMIN_ROLE");
		//disable Cross Site Request Fogery
		http.csrf().disable();
		
		http.authorizeRequests()
		// page don't need log in
		.antMatchers("/login", "/logout").permitAll()

		// page need log in as USER 
		.antMatchers("/homepage","/person/view-list","/person/search-person").access("hasRole('USER')")

		// page only for ADMIN
		.antMatchers("/finance/list-finance").access("hasRole('ADMIN')")
		
		// page only for SUPER_ADMIN
		.antMatchers("/person/add-person","/person/add-person-by-excel").access("hasRole('SUPER_ADMIN')")
		// While USER access page of ADMIN throw exception
		.and()
		.exceptionHandling().accessDeniedPage("/403")

		// config login form
		.and()
		.formLogin()
		.loginProcessingUrl("/j_spring_security_login").loginPage("/login")
		.defaultSuccessUrl("/homepage")
		.usernameParameter("username")
		.passwordParameter("password")
		
		// config log out page
		.and()
		.logout()
		.logoutUrl("/j_spring_security_logout")
		.logoutSuccessUrl("/logoutSuccessfull");

	}
}
