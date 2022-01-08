/**
 * 
 */
package com.komal.keycloak.example.ResourceServer.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

/**
 * @author kkadam
 *
 */
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
		http.authorizeRequests((requests) -> requests.antMatchers(HttpMethod.GET, "/users/status/check")
				//.hasAuthority("SCOPE_profile")
				//.hasAnyRole("developer")
				.hasRole("developer")
				//.hasAuthority("ROLE_developer")
				.anyRequest().authenticated());
		http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter);
	}
}
