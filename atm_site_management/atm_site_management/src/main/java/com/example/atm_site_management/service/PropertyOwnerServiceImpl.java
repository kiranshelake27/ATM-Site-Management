package com.example.atm_site_management.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.atm_site_management.dto.PropertyOwnerDto;
import com.example.atm_site_management.entity.PropertyOwner;
import com.example.atm_site_management.repository.PropertyOwnerRepository;

@Service
public class PropertyOwnerServiceImpl implements PropertyOwnerService {

	@Autowired
	private PropertyOwnerRepository propertyOwnerRepository;

	@Override
	public PropertyOwnerDto createOrUpdatePropertyOwner(PropertyOwnerDto propertyOwnerDto) {
		PropertyOwner propertyOwner = new PropertyOwner();
		if (propertyOwnerDto.getId() != null) {
			propertyOwner = propertyOwnerRepository.findById(propertyOwnerDto.getId()).orElse(new PropertyOwner());
		}
		propertyOwner.setName(propertyOwnerDto.getName());
		propertyOwner.setContactDetails(propertyOwnerDto.getContactDetails());
		propertyOwner.setBankAccountInfo(propertyOwnerDto.getBankAccountInfo());

		propertyOwner = propertyOwnerRepository.save(propertyOwner);

		return convertToDto(propertyOwner);

	}

	@Override
	public PropertyOwnerDto getPropertyOwnerById(Long id) {
		PropertyOwner propertyOwner = propertyOwnerRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Property Owner not found"));
		return convertToDto(propertyOwner);
	}

	@Override
	public void deletePropertyOwner(Long id) {
		PropertyOwner propertyOwner = propertyOwnerRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Property Owner not found"));
		propertyOwnerRepository.delete(propertyOwner);
	}

	private PropertyOwnerDto convertToDto(PropertyOwner propertyOwner) {
		PropertyOwnerDto dto = new PropertyOwnerDto();
		dto.setId(propertyOwner.getId());
		dto.setName(propertyOwner.getName());
		dto.setContactDetails(propertyOwner.getContactDetails());
		dto.setBankAccountInfo(propertyOwner.getBankAccountInfo());
		return dto;
	}

	public List<PropertyOwnerDto> getAllPropertyOwners() {
		return propertyOwnerRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
	}
}
