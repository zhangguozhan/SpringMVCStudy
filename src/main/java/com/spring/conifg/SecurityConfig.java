package com.spring.conifg;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;

@Configurable
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger logger = LogManager.getLogger(SecurityConfig.class);

	public SecurityConfig() {
		logger.info("==============SecurityConfig.class=======create=============");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login").and().logout().logoutSuccessUrl("/").and().rememberMe()
				.tokenRepository(new InMemoryTokenRepositoryImpl()).tokenValiditySeconds(2419200).key("spittrKey").and()
				.httpBasic().realmName("Spittr").and().authorizeRequests().antMatchers("/").authenticated()
				.antMatchers("/spitter/me").authenticated().antMatchers(HttpMethod.POST, "/spittles").authenticated()
				.anyRequest().permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("==============SecurityConfig.configure=======create=============");
		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and()
		.withUser("admin").password("password").roles("USER", "ADMIN");
	}

}
