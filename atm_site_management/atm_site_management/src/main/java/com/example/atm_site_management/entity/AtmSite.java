package com.example.atm_site_management.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class AtmSite {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String siteCode;
	    private String address;
	    private String status;
	    private Date installationDate;

	    @ManyToOne
	    @JoinColumn(name = "property_owner_id", nullable = false)
	    private PropertyOwner propertyOwner;

}
