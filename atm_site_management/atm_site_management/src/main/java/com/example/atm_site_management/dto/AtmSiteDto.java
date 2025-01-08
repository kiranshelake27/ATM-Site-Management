package com.example.atm_site_management.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AtmSiteDto {

	 private Long id;
	    private String siteCode;
	    private String address;
	    private String status;
	    private Date installationDate;
	    private Long propertyOwnerId;
		
}
