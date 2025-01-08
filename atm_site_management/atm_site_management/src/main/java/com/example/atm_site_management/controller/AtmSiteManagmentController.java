package com.example.atm_site_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.atm_site_management.dto.AtmSiteDto;
import com.example.atm_site_management.service.AtmSiteService;

@RestController
@RequestMapping("/api/atm-sites")
public class AtmSiteManagmentController {

	@Autowired
	AtmSiteService atmsiteService;

	@GetMapping
	public ResponseEntity<List<AtmSiteDto>> getAllAtmSites() {
		return ResponseEntity.ok(atmsiteService.getAllAtmSites());
	}

	@PostMapping("/create-or-update")
	public ResponseEntity<AtmSiteDto> createAtmSite(@RequestBody AtmSiteDto atmSitedto) {
		AtmSiteDto createdAtmSite = atmsiteService.createAtmSite(atmSitedto);
		return new ResponseEntity<>(createdAtmSite, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public AtmSiteDto getAtmSiteById(@PathVariable Long id) {
		return atmsiteService.getAtmSiteById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteAtmSite(@PathVariable Long id) {
		atmsiteService.deleteAtmSite(id);
	}

}
