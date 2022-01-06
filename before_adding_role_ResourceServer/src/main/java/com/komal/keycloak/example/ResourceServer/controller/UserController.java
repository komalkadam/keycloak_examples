/**
 * 
 */
package com.komal.keycloak.example.ResourceServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kkadam
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	@GetMapping("/status/check")
	public String status() {
		return "User controller in Resource server is up and running";
	}
}
