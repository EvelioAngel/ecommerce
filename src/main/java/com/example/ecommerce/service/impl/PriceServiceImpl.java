package com.example.ecommerce.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ecommerce.entities.Price;
import com.example.ecommerce.repository.PriceRepository;
import com.example.ecommerce.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

	private final PriceRepository priceRepository;

	public PriceServiceImpl(PriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}

	@Override
	public List<Price> getByQuery(LocalDateTime applicationDate, Long productId, Long brandId) {
		return priceRepository.findByApplicationDateProductIdBrandId(applicationDate, productId, brandId);
	}

}
