package com.example.atm_site_management.dto;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
@Data
public class LeaseAgreementDto {
	    private Long id;
	    private Long atmSiteId; 
	    private Date startDate;
	    private Date endDate;
	    private BigDecimal rentAmount;
}
