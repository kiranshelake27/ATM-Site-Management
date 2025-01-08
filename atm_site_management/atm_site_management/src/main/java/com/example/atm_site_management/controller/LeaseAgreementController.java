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

import com.example.atm_site_management.dto.LeaseAgreementDto;
import com.example.atm_site_management.service.LeaseAgreementService;

@RestController
@RequestMapping("/api/lease-agreement")
public class LeaseAgreementController {

	@Autowired
	private LeaseAgreementService leaseAgreementService;

	@GetMapping
	public List<LeaseAgreementDto> getAllLeaseAgreements() {
		return leaseAgreementService.getAllLeaseAgreements();
	}

	@PostMapping("/create-or-update")
	public ResponseEntity<LeaseAgreementDto> createOrUpdateLeaseAgreement(
			@RequestBody LeaseAgreementDto leaseAgreementDto) {
		LeaseAgreementDto savedAgreement = leaseAgreementService.createOrUpdateLeaseAgreement(leaseAgreementDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedAgreement);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LeaseAgreementDto> getLeaseAgreementById(@PathVariable Long id) {
		LeaseAgreementDto leaseAgreementDto = leaseAgreementService.getLeaseAgreementById(id);
		return ResponseEntity.ok(leaseAgreementDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLeaseAgreement(@PathVariable Long id) {
		leaseAgreementService.deleteLeaseAgreement(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
