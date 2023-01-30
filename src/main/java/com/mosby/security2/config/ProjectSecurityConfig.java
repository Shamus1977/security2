package com.mosby.security2.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
		//In development disable crsf, if not you cannot make changes to the database, like registering.
		
		http.csrf().disable().authorizeHttpRequests()
			.requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
			.requestMatchers("/notices", "/contact", "/register").permitAll()
			.and().formLogin().and().httpBasic();
			
		http.formLogin();
		http.httpBasic();
		return http.build();
	}
	
	
	// In memory approach for initial testing only.
//	@SuppressWarnings("deprecation")
//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//		
//		UserDetails admin = User.withDefaultPasswordEncoder()
//				.username("admin")
//				.password("123")
//				.authorities("admin")
//				.build();
//		UserDetails user = User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("123")
//				.authorities("read")
//				.build();
//		return new InMemoryUserDetailsManager(admin, user);
//	}
	
//	@Bean
//	public UserDetailsService userDetailsService(DataSource dataSource) {
//		return new JdbcUserDetailsManager(dataSource);
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() { 
		return new BCryptPasswordEncoder();
	}
}














