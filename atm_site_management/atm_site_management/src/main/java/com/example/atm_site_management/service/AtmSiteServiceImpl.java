package com.example.atm_site_management.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atm_site_management.dto.AtmSiteDto;
import com.example.atm_site_management.entity.AtmSite;
import com.example.atm_site_management.entity.PropertyOwner;
import com.example.atm_site_management.repository.AtmSiteRepository;
import com.example.atm_site_management.repository.PropertyOwnerRepository;

@Service
public class AtmSiteServiceImpl implements AtmSiteService {

	@Autowired
	private AtmSiteRepository atmSiteRepository;

	@Autowired
	private PropertyOwnerRepository propertyOwnerRepository;

	private AtmSiteDto convertToDto(AtmSite atmSite) {
		AtmSiteDto dto = new AtmSiteDto();
		dto.setId(atmSite.getId());
		dto.setSiteCode(atmSite.getSiteCode());
		dto.setAddress(atmSite.getAddress());
		dto.setStatus(atmSite.getStatus());
		dto.setInstallationDate(atmSite.getInstallationDate());
		dto.setPropertyOwnerId(atmSite.getPropertyOwner().getId());
		return dto;
	}

	@Override
	public AtmSiteDto createAtmSite(AtmSiteDto atmSitedto) {
		AtmSite atmSite = new AtmSite();
		if (atmSitedto.getId() != null) {
			atmSite = atmSiteRepository.findById(atmSitedto.getId()).orElse(new AtmSite()); // if updating, get
																							// existing, else new
		}
		atmSite.setSiteCode(atmSitedto.getSiteCode());
		atmSite.setAddress(atmSitedto.getAddress());
		atmSite.setStatus(atmSitedto.getStatus());
		atmSite.setInstallationDate(atmSitedto.getInstallationDate());

		// Set PropertyOwner
		PropertyOwner propertyOwner = propertyOwnerRepository.findById(atmSitedto.getPropertyOwnerId())
				.orElseThrow(() -> new IllegalArgumentException("Property Owner not found"));
		atmSite.setPropertyOwner(propertyOwner);

		atmSite = atmSiteRepository.save(atmSite);

		return convertToDto(atmSite);
	}

	@Override
	public List<AtmSiteDto> getAllAtmSites() {
		List<AtmSite> atmSites = atmSiteRepository.findAll();
		return atmSites.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	@Override
	public AtmSiteDto getAtmSiteById(Long id) {
		AtmSite atmSite = atmSiteRepository.findById(id).orElseThrow(() -> new RuntimeException("ATM Site not found"));
		return convertToDto(atmSite);
	}

	@Override
	public void deleteAtmSite(Long id) {
		AtmSite atmSite = atmSiteRepository.findById(id).orElseThrow(() -> new RuntimeException("ATM Site not found"));
		atmSiteRepository.delete(atmSite);
	}
}
