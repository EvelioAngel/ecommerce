package com.example.ecommerce;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.ecommerce.dto.PriceDto;
import com.example.ecommerce.entities.Price;

public class DataBuilderUtil {

	public static final String STRING_VALUE = "value";
	public static final Long LONG_VALUE = 1L;
	public static final String DATE_AS_STRING_VALUE = "2020-06-14T00:00:00";
	public static final BigDecimal BIGDECIMAL_VALUE = BigDecimal.TEN;
	public static final LocalDateTime LOCALDATETIME_VALUE = LocalDateTime.now();

	public static Price buildPrice() {
		return Price.builder().id(LONG_VALUE).brandId(LONG_VALUE).startDate(LOCALDATETIME_VALUE)
				.endDate(LOCALDATETIME_VALUE).priceList(LONG_VALUE).productId(LONG_VALUE).price(BIGDECIMAL_VALUE)
				.priority(LONG_VALUE).curr(STRING_VALUE).build();
	}

	public static PriceDto buildPriceDto() {
		return PriceDto.builder().brandId(1L).startDate(LocalDateTime.now()).endDate(LocalDateTime.now()).priceList(1L)
				.productId(35455L).price(BigDecimal.TEN).curr("EUR").build();
	}
}
