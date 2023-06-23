package com.example.ecommerce.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.ecommerce.DataBuilderUtil;
import com.example.ecommerce.mappers.PriceMapper;
import com.example.ecommerce.service.PriceService;

@AutoConfigureMockMvc
@WebMvcTest(controllers = PriceController.class)
class PriceControllerUnitTest {

	private final String BASE_URL = "/prices/query?applicationDate=%s&productId=%s&brandId=%s";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PriceService priceService;

	@MockBean
	private PriceMapper priceMapper;

	@Test
	void when_getByQuery_expect_ok() throws Exception {
		when(priceService.getByQuery(any(),anyLong(),anyLong()))
        .thenReturn(Arrays.asList(DataBuilderUtil.buildPrice()) );
		
		String url = String.format( BASE_URL,DataBuilderUtil.DATE_AS_STRING_VALUE, DataBuilderUtil.LONG_VALUE,DataBuilderUtil.LONG_VALUE);

		this.mockMvc.perform(get(url))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$").isNotEmpty());
		
		verify(priceService, times(1)).getByQuery(any(), anyLong(), anyLong());
	    verifyNoMoreInteractions(priceService);
	    verify(priceMapper, times(1)).mapToDto(any());
	    verifyNoMoreInteractions(priceMapper);
	}

	@Test
	void when_getByQuery_expect_empty() throws Exception {
		when(priceService.getByQuery(any(),anyLong(),anyLong()))
        .thenReturn(Collections.emptyList());
		
		String url = String.format( BASE_URL,DataBuilderUtil.DATE_AS_STRING_VALUE, DataBuilderUtil.LONG_VALUE,DataBuilderUtil.LONG_VALUE);

		this.mockMvc.perform(get(url))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$").isEmpty());
		
		verify(priceService, times(1)).getByQuery(any(), anyLong(), anyLong());
	    verifyNoMoreInteractions(priceService);
	    verifyNoInteractions(priceMapper);
	}

	@BeforeEach
	void setUp() {
		when(priceMapper.mapToDto(any()))
        .thenReturn(DataBuilderUtil.buildPriceDto()) ;
	}
}
