package com.jeancaslv.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	  @Autowired
	  private JwtTokenProvider jwtTokenProvider;

	  @Override
	  protected void configure(HttpSecurity http) throws Exception {

	    http.csrf().disable();

	    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

	    http.authorizeRequests()//
	        .antMatchers("/usuario/login").permitAll()
	        .antMatchers("/usuario").permitAll()
	        .anyRequest().authenticated();
	    

	    http.exceptionHandling().accessDeniedPage("/login");

	    http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));

	  }


	  @Override
	  @Bean
	  public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	  }

}
