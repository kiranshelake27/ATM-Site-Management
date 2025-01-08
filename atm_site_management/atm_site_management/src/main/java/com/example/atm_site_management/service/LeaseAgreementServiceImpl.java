package com.example.atm_site_management.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.atm_site_management.dto.LeaseAgreementDto;
import com.example.atm_site_management.entity.AtmSite;
import com.example.atm_site_management.entity.LeaseAgreement;
import com.example.atm_site_management.repository.AtmSiteRepository;
import com.example.atm_site_management.repository.LeaseAgreementRepository;

@Service
public class LeaseAgreementServiceImpl implements LeaseAgreementService {

	@Autowired
	private LeaseAgreementRepository leaseAgreementRepository;

	@Autowired
	private AtmSiteRepository atmSiteRepository;

	@Override
	public LeaseAgreementDto createOrUpdateLeaseAgreement(LeaseAgreementDto leaseAgreementDto) {
		LeaseAgreement leaseAgreement = new LeaseAgreement();
		if (leaseAgreementDto.getId() != null) {
			leaseAgreement = leaseAgreementRepository.findById(leaseAgreementDto.getId()).orElse(new LeaseAgreement());
		}
		AtmSite atmSite = atmSiteRepository.findById(leaseAgreementDto.getAtmSiteId())
				.orElseThrow(() -> new IllegalArgumentException("ATM Site not found"));

		leaseAgreement.setAtmSite(atmSite);
		leaseAgreement.setStartDate(leaseAgreementDto.getStartDate());
		leaseAgreement.setEndDate(leaseAgreementDto.getEndDate());
		leaseAgreement.setRentAmount(leaseAgreementDto.getRentAmount());
		leaseAgreement = leaseAgreementRepository.save(leaseAgreement);

		return convertToDto(leaseAgreement);
	}

	@Override
	public LeaseAgreementDto getLeaseAgreementById(Long id) {
		LeaseAgreement leaseAgreement = leaseAgreementRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Lease Agreement not found"));
		return convertToDto(leaseAgreement);
	}

	@Override
	public void deleteLeaseAgreement(Long id) {
		LeaseAgreement leaseAgreement = leaseAgreementRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Lease Agreement not found"));
		leaseAgreementRepository.delete(leaseAgreement);
	}

	private LeaseAgreementDto convertToDto(LeaseAgreement leaseAgreement) {
		LeaseAgreementDto dto = new LeaseAgreementDto();
		dto.setId(leaseAgreement.getId());
		dto.setAtmSiteId(leaseAgreement.getAtmSite().getId());
		dto.setStartDate(leaseAgreement.getStartDate());
		dto.setEndDate(leaseAgreement.getEndDate());
		dto.setRentAmount(leaseAgreement.getRentAmount());
		return dto;
	}

	public List<LeaseAgreementDto> getAllLeaseAgreements() {
		return leaseAgreementRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}
}
