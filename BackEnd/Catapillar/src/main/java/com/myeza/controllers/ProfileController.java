package com.myeza.controllers;

import java.util.List;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myeza.models.Campaign;
import com.myeza.models.Profile;
import com.myeza.services.ProfileService;

@RequestMapping("/profiles")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileController {
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping()
	public List<Profile> getProfiles(){
		List<Profile> profiles = profileService.findAll();
		Collections.shuffle(profiles);
		return profiles;
	}
	
	@GetMapping("/{id}")
	public Profile getProfile(@PathVariable("id") String id){
		return profileService.findById(id);
	}
	
	@GetMapping("{id}/campaigns")
	public List<Campaign> getProfileCampaigns(@PathVariable("id") String id){
		return profileService.findProfileCampaigns(id);
	}
	
	@GetMapping("/{name}")
	public Profile getProfileByName(@PathVariable("name") String name){
		return profileService.findByName(name);
	}

}
