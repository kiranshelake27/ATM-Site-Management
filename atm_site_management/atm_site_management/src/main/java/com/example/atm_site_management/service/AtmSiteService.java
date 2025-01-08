package com.example.atm_site_management.service;

import java.util.List;

import com.example.atm_site_management.dto.AtmSiteDto;

public interface AtmSiteService {

	List<AtmSiteDto> getAllAtmSites();

	AtmSiteDto createAtmSite(AtmSiteDto atmSitedto);

	AtmSiteDto getAtmSiteById(Long id);

	void deleteAtmSite(Long id);

}
