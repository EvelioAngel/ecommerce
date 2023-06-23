package com.example.ecommerce.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.ecommerce.entities.Price;

public interface PriceService {

	List<Price> getByQuery(LocalDateTime applicationDate, Long productId, Long brandId);

}
