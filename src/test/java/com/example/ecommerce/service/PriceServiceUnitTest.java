package com.example.ecommerce.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ecommerce.DataBuilderUtil;
import com.example.ecommerce.entities.Price;
import com.example.ecommerce.repository.PriceRepository;
import com.example.ecommerce.service.impl.PriceServiceImpl;

@SpringBootTest
class PriceServiceUnitTest {

	@Mock
	private PriceRepository priceRepository;

	@InjectMocks
	private PriceServiceImpl priceService;

	@Test
	void when_getByQuery_expect_ok() {
		when(priceRepository.findByApplicationDateProductIdBrandId(any(), anyLong(), anyLong()))
				.thenReturn(Arrays.asList(DataBuilderUtil.buildPrice()));

		List<Price> prices = priceService.getByQuery(LocalDateTime.now(), DataBuilderUtil.LONG_VALUE,
				DataBuilderUtil.LONG_VALUE);

		assertThat(prices).isNotEmpty().hasSize(1);
		assertThat(prices.get(0).getBrandId()).isEqualTo(DataBuilderUtil.LONG_VALUE);
		assertThat(prices.get(0).getCurr()).isEqualTo(DataBuilderUtil.STRING_VALUE);
		assertThat(prices.get(0).getEndDate()).isEqualTo(DataBuilderUtil.LOCALDATETIME_VALUE);
		assertThat(prices.get(0).getId()).isEqualTo(DataBuilderUtil.LONG_VALUE);
		assertThat(prices.get(0).getPrice()).isEqualTo(DataBuilderUtil.BIGDECIMAL_VALUE);
		assertThat(prices.get(0).getPriceList()).isEqualTo(DataBuilderUtil.LONG_VALUE);
		assertThat(prices.get(0).getPriority()).isEqualTo(DataBuilderUtil.LONG_VALUE);
		assertThat(prices.get(0).getProductId()).isEqualTo(DataBuilderUtil.LONG_VALUE);
		assertThat(prices.get(0).getStartDate()).isEqualTo(DataBuilderUtil.LOCALDATETIME_VALUE);
		
		verify(priceRepository, times(1)).findByApplicationDateProductIdBrandId(any(), anyLong(), anyLong());
	    verifyNoMoreInteractions(priceRepository);
	}

	@Test
	void when_getByQuery_expect_empty() throws Exception {
		when(priceRepository.findByApplicationDateProductIdBrandId(any(), anyLong(), anyLong()))
		.thenReturn(Collections.emptyList());

		List<Price> prices = priceService.getByQuery(LocalDateTime.now(), DataBuilderUtil.LONG_VALUE, DataBuilderUtil.LONG_VALUE);
		
		assertThat(prices).isNotNull().isEmpty();
		
		verify(priceRepository, times(1)).findByApplicationDateProductIdBrandId(any(), anyLong(), anyLong());
	    verifyNoMoreInteractions(priceRepository);
	}
}
