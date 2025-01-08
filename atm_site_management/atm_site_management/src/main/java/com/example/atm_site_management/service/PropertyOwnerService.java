package com.example.atm_site_management.service;

import java.util.List;

import com.example.atm_site_management.dto.PropertyOwnerDto;

public interface PropertyOwnerService {

	 PropertyOwnerDto createOrUpdatePropertyOwner(PropertyOwnerDto propertyOwnerDto);

	    PropertyOwnerDto getPropertyOwnerById(Long id);

	    void deletePropertyOwner(Long id);

		List<PropertyOwnerDto> getAllPropertyOwners();

}
