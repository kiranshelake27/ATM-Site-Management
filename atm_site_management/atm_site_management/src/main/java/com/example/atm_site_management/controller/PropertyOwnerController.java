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

import com.example.atm_site_management.dto.PropertyOwnerDto;
import com.example.atm_site_management.service.PropertyOwnerService;

@RestController
@RequestMapping("/api/property-owner")
public class PropertyOwnerController {

	@Autowired
	private PropertyOwnerService propertyOwnerService;

	@GetMapping
	public List<PropertyOwnerDto> getAllPropertyOwners() {
		return propertyOwnerService.getAllPropertyOwners();
	}

	@PostMapping("/create-or-update")
	public ResponseEntity<PropertyOwnerDto> createOrUpdatePropertyOwner(
			@RequestBody PropertyOwnerDto propertyOwnerDto) {
		PropertyOwnerDto savedOwner = propertyOwnerService.createOrUpdatePropertyOwner(propertyOwnerDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedOwner);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PropertyOwnerDto> getPropertyOwnerById(@PathVariable Long id) {
		PropertyOwnerDto ownerDto = propertyOwnerService.getPropertyOwnerById(id);
		return ResponseEntity.ok(ownerDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePropertyOwner(@PathVariable Long id) {
		propertyOwnerService.deletePropertyOwner(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
