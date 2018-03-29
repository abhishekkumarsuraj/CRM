package com.suraj.springDemo.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;

	//ref to our securityDataSource
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		
		//jdbc Authentication
				auth.jdbcAuthentication().dataSource(securityDataSource);
			
//	
//		//Add our users for in-memory Authentication
//		
//		UserBuilder users=User.withDefaultPasswordEncoder();
//		
//		auth.inMemoryAuthentication()
//		.withUser(users.username("suraj").password("test123").roles("Employee"))
//		.withUser(users.username("mary").password("test123").roles("Manager"))
//		.withUser(users.username("susan").password("test123").roles("Admin"));
	}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
		
			http.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			         .loginPage("/showMyLoginPage")
			         .loginProcessingUrl("/authenticateTheUser")
			         .permitAll()
			         .and()
			         .logout()
			         .permitAll()
			         .and()
			         .exceptionHandling()
			         .accessDeniedPage("/access-denied");
		}	
		
		
		
	
}
