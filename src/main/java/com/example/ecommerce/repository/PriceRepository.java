package com.example.ecommerce.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecommerce.entities.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {

	@Query(value = "FROM Price WHERE productId = :productId AND brandId = :brandId AND :applicationDate BETWEEN startDate AND endDate "
			+ "ORDER BY startDate ASC")
	List<Price> findByApplicationDateProductIdBrandId(@Param("applicationDate") LocalDateTime applicationDate,
			@Param("productId") Long productId, @Param("brandId") Long brandId);
}
