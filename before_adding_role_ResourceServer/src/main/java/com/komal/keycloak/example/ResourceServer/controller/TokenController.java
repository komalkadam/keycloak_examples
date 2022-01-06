/**
 * 
 */
package com.komal.keycloak.example.ResourceServer.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kkadam
 *
 */
@RestController
@RequestMapping("/token")
public class TokenController {
	
	@GetMapping
	public Map<String, Object> getToken(@AuthenticationPrincipal Jwt jwt) {
		return Collections.singletonMap("priincipal", jwt);
	}
}
