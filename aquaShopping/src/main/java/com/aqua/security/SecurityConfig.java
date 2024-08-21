package com.aqua.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	@Autowired
	SecurityUserDetailsService	securityUserDetail;
	
	@Bean
	SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {
	    http.authorizeHttpRequests(authorize -> authorize
	              .requestMatchers("/aquarium/login/loginForm").authenticated()
	              .requestMatchers("/manager/Form").hasRole("ADMIN")
	              .requestMatchers("/aquarium/cartList")
	              .hasAnyRole("GUEST","MEMBER", "ADMIN")	             
	              .anyRequest().permitAll())
				
		.csrf(csrf ->csrf.disable())	
	    
		.formLogin(login ->login.loginPage("/login/loginForm").defaultSuccessUrl("/index", true)) // index 대신 매핑해서 컨트롤러에서 세션처리
		.exceptionHandling(handling ->handling.accessDeniedPage("/login/accessDenied"))
		.logout(logout ->logout.invalidateHttpSession(true).logoutSuccessUrl("/index"))
		.userDetailsService(securityUserDetail);
		return http.build(); 
	}
	
    @Bean
    public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();		
	}
}