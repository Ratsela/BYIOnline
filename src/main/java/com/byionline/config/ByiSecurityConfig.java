package com.byionline.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class ByiSecurityConfig extends WebSecurityConfigurerAdapter {

	/*@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable();
		
		httpSecurity.authorizeRequests()
		.antMatchers("byi/adminHome").hasRole("Admin")
		.and()
		.formLogin()
		.loginPage("/views/login");
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests()
		.antMatchers("/byi").permitAll()
		.antMatchers("/byi/adminHome").hasRole("Admin")
		.and()
		.formLogin()
		.defaultSuccessUrl("/byi/adminHome")
		.loginPage("/byi/admin");
	}
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("ratselamarch@gmail.com").password("123").roles("Admin");
	}
	
}
