package com.myeza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myeza.services.ProfileService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.myeza.models.Campaign;
import com.myeza.models.Profile;

@RequestMapping("/profiles")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping()
	public Flux<Profile> getProfiles(){
		return profileService.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Profile> getProfile(@PathVariable("id") String id){
		return profileService.findById(id);
	}
	
	@GetMapping("{id}/campaigns")
	public Flux<Campaign> getProfileCampaigns(@PathVariable("id") String id){
		return profileService.findProfileCampaigns(id);
	}
	
	@GetMapping("/{name}")
	public Flux<Profile> getProfileByName(@PathVariable("name") String name){
		return profileService.findByName(name);
	}

}
