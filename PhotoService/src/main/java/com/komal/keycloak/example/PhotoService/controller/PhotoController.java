/**
 * 
 */
package com.komal.keycloak.example.PhotoService.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komal.keycloak.example.PhotoService.model.PhotoDto;



/**
 * @author kkadam
 *
 */
@RestController
@RequestMapping("/photos")
public class PhotoController {
	
	
	@GetMapping
	public List<PhotoDto> getUser(@AuthenticationPrincipal Jwt jwt) {
		PhotoDto photo1 = new PhotoDto();
		photo1.setId("1");
		photo1.setUserid("1");
		photo1.setName("Photo 1");
		photo1.setDescription("Sample Photo 1");
		photo1.setUrl("Random URL for Photo 1");
		
		PhotoDto photo2 = new PhotoDto();
		photo2.setId("2");
		photo2.setUserid("2");
		photo2.setName("Photo 2");
		photo2.setDescription("Sample Photo 2");
		photo2.setUrl("Random URL for Photo 2");
		return Arrays.asList(photo1, photo2); 
	}
}
