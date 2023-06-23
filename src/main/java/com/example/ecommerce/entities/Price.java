package com.example.ecommerce.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "PRICES")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Price implements Serializable {

	private static final long serialVersionUID = 2610101956982344703L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "BRAND_ID", nullable = false)
	private Long brandId;

	@Column(name = "START_DATE", nullable = false, columnDefinition = "TIMESTAMP")
	private LocalDateTime startDate;

	@Column(name = "END_DATE", nullable = false, columnDefinition = "TIMESTAMP")
	private LocalDateTime endDate;

	@Column(name = "PRICE_LIST", nullable = false)
	private Long priceList;

	@Column(name = "PRODUCT_ID", nullable = false)
	private Long productId;

	@Column(name = "PRIORITY", nullable = false)
	private Long priority;

	@Column(name = "PRICE", nullable = false)
	private BigDecimal price;

	@Column(name = "CURR", nullable = false)
	private String curr;

}
