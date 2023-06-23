package com.example.ecommerce.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.PriceDto;
import com.example.ecommerce.mappers.PriceMapper;
import com.example.ecommerce.service.PriceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/prices", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Prices")
public class PriceController {

	private final PriceService priceService;

	private final PriceMapper priceMapper;

	public PriceController(PriceService priceService, PriceMapper priceMapper) {
		this.priceService = priceService;
		this.priceMapper = priceMapper;
	}

	@GetMapping("/query")
	@Operation(summary = "Get entities by params", description = "A list of all entities in the database")
	public ResponseEntity<List<PriceDto>> getByQuery(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime applicationDate,
			@RequestParam Long productId, @RequestParam Long brandId) {
		List<PriceDto> prices = priceService.getByQuery(applicationDate, productId, brandId).stream()
				.map(priceMapper::mapToDto).toList();
		return ResponseEntity.ok(prices);
	}
}
