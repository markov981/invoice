package com.libertymutual.goforcode.invoice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.libertymutual.goforcode.invoice.services.InvoiceUserDetailService;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	
	private InvoiceUserDetailService userDetailsService;
	
	public SecurityConfiguration(InvoiceUserDetailService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
		
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				.antMatchers("/", "/signup", "/css/**", "/js/**").permitAll() 
				.antMatchers("/billing-records/**").hasAnyRole("ADMIN", "CLERK")
				.antMatchers("/invoices/**").hasAnyRole("ADMIN", "ACCOUNTANT")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated() 
			.and()
			.formLogin();			
	}	
		
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Override
	public UserDetailsService userDetailsService() {
		return userDetailsService;
	}	
}