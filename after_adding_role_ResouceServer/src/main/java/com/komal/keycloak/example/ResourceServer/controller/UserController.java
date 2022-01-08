/**
 * 
 */
package com.komal.keycloak.example.ResourceServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komal.keycloak.example.ResourceServer.model.UserDTO;

/**
 * @author kkadam
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	Environment env;
	
	@GetMapping("/status/check")
	public String status() {
		return "User controller in Resource server is up and running on port " + env.getProperty("local.server.port");
	}
	
	//@Secured("ROLE_developer")
	@PreAuthorize("hasRole('developer') or #id == #jwt.subject")
	@DeleteMapping(path = "/{id}")
	public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
		return "Deleted user with the id " + id + " and Jwt subject is " + jwt.getSubject(); 
	}
	
	@PostAuthorize("returnObject.id == #jwt.subject")
	@GetMapping(path = "/{id}")
	public UserDTO getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
		return new UserDTO("Komal", "Kadam", "1531e7ab-757f-4acc-acf8-f54f0f3d13bb"); 
	}
}
