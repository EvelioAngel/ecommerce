package com.example.ecommerce.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceDto implements Serializable {

	private static final long serialVersionUID = 5361167238404562650L;

	private Long brandId;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	private Long priceList;

	private Long productId;

	private BigDecimal price;

	private String curr;
}
