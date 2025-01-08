package com.example.atm_site_management.dto;

import java.util.List;

import lombok.Data;

@Data
public class PropertyOwnerDto {
	private Long id;
    private String name;
    private String contactDetails;
    private String bankAccountInfo;
    private List<Long> atmSiteIds;

}
