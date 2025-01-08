package com.example.atm_site_management.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class PropertyOwner {

	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String contactDetails;
	    private String bankAccountInfo;

	    @OneToMany(mappedBy = "propertyOwner", cascade = CascadeType.ALL)
	    private List<AtmSite> atmSites;
}
