package com.inn.cafe.JWT;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity

public class SecurityConfig  implements WebSecurityConfigurerAdapter{

	

	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService();
	}
	
	

}
