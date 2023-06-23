package com.example.ecommerce.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ecommerce.DataBuilderUtil;
import com.example.ecommerce.dto.PriceDto;

@SpringBootTest
class PriceMapperUnitTest {

	@InjectMocks
	private PriceMapperImpl priceMapper;

	@Test
	void when_priceMapper_expect_dto() {
		PriceDto priceDto = priceMapper.mapToDto(DataBuilderUtil.buildPrice());

		assertThat(priceDto).isNotNull();
		assertThat(priceDto.getBrandId()).isEqualTo(DataBuilderUtil.LONG_VALUE);
		assertThat(priceDto.getCurr()).isEqualTo(DataBuilderUtil.STRING_VALUE);
		assertThat(priceDto.getEndDate()).isEqualTo(DataBuilderUtil.LOCALDATETIME_VALUE);
		assertThat(priceDto.getPrice()).isEqualTo(DataBuilderUtil.BIGDECIMAL_VALUE);
		assertThat(priceDto.getPriceList()).isEqualTo(DataBuilderUtil.LONG_VALUE);
		assertThat(priceDto.getProductId()).isEqualTo(DataBuilderUtil.LONG_VALUE);
		assertThat(priceDto.getStartDate()).isEqualTo(DataBuilderUtil.LOCALDATETIME_VALUE);
	}
}
