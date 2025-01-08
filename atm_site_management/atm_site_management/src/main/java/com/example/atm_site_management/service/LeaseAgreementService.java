package com.example.atm_site_management.service;

import java.util.List;

import com.example.atm_site_management.dto.LeaseAgreementDto;

public interface LeaseAgreementService {
	
	 LeaseAgreementDto createOrUpdateLeaseAgreement(LeaseAgreementDto leaseAgreementDto);

	    LeaseAgreementDto getLeaseAgreementById(Long id);

	    void deleteLeaseAgreement(Long id);

		List<LeaseAgreementDto> getAllLeaseAgreements();

}
