/**
 * 
 */
package com.komal.keycloak.example.ResourceServer.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author kkadam
 *
 */
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests((requests) -> requests.antMatchers(HttpMethod.GET, "/users/status/check")
				.hasAuthority("SCOPE_profile").anyRequest().authenticated());
		http.oauth2ResourceServer().jwt();
	}
}
