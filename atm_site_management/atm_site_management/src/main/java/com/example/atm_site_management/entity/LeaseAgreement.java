package com.example.atm_site_management.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class LeaseAgreement {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @OneToOne
	    @JoinColumn(name = "atm_site_id", nullable = false)
	    private AtmSite atmSite;
	    private Date startDate;
	    private Date endDate;
	    private BigDecimal rentAmount;
}
