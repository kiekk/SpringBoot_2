package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.service.UserService;

import lombok.Setter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Setter(onMethod_ = @Autowired)
	private UserService u_service;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/user/**", "/board/list").permitAll()	//������ ���� ���
		.and()
		.authorizeRequests()
		.antMatchers("/board/get/**", "/board/register/**", "/board/modify/**").hasRole("ROLE_MEMBER")	//�α��� ����ڸ� ���� ����
		.and()
		.formLogin().loginPage("/user/login")	//�α��� ������
		.defaultSuccessUrl("/board/list")	//�α��� ������ �����̷�Ʈ �ּ�
		.and()
		.logout()						//�α׾ƿ�
		.logoutSuccessUrl("/")			//�α׾ƿ� ������ �����̷�Ʈ �ּ�
		.invalidateHttpSession(true);	//���� ����
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	}
}
