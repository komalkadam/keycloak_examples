/**
 * 
 */
package com.komal.keycloak.example.AlbumService.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komal.keycloak.example.AlbumService.model.AlbumDto;


/**
 * @author kkadam
 *
 */
@RestController
@RequestMapping("/albums")
public class AlbumController {
	
	
	@GetMapping
	public List<AlbumDto> getUser(@AuthenticationPrincipal Jwt jwt) {
		AlbumDto album1 = new AlbumDto();
		album1.setId("1");
		album1.setUserid("1");
		album1.setName("Album 1");
		album1.setDescription("Sample Album 1");
		album1.setUrl("Random URL for Album 1");
		
		AlbumDto album2 = new AlbumDto();
		album2.setId("2");
		album2.setUserid("2");
		album2.setName("Album 2");
		album2.setDescription("Sample Album 2");
		album2.setUrl("Random URL for Album 2");
		return Arrays.asList(album1, album2); 
	}
}
