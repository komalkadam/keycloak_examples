/**
 * 
 */
package com.komal.keycloak.example.ResourceServer.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

/**
 * @author kkadam
 *
 */
public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>>{

	@Override
	public Collection<GrantedAuthority> convert(Jwt source) {
		Map<String, Object> realms_access = (Map<String, Object>) source.getClaims().get("realm_access");
		if (realms_access == null || realms_access.isEmpty())
			return new ArrayList<GrantedAuthority>();
		Collection<GrantedAuthority> authority = ((List<String>) realms_access.get("roles"))
				.stream().map(role -> "ROLE_"+role)
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		return authority;
	}

}
