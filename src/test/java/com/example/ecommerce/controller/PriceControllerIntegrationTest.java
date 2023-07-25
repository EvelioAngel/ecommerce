package com.example.ecommerce.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PriceControllerIntegrationTest {

	private final String BASE_URL = "/prices/query?applicationDate=%s&productId=%s&brandId=%s";

	@Autowired
	private MockMvc mockMvc;

	@Test
	void when_getByQuery_expect_ok_case1() throws Exception {
		String url = String.format(BASE_URL, "2020-06-14T10:00:00", "35455", "1");
		//@formatter:off
		this.mockMvc.perform(get(url))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isNotEmpty())	
		.andExpect(jsonPath("$.length()").value(1))
		.andExpect(jsonPath("$[0].brandId").value(1))
		.andExpect(jsonPath("$[0].startDate").value("2020-06-14T00:00:00"))
		.andExpect(jsonPath("$[0].endDate").value("2020-12-31T23:59:59"))
		.andExpect(jsonPath("$[0].priceList").value(1))
		.andExpect(jsonPath("$[0].productId").value(35455))
		.andExpect(jsonPath("$[0].price").value(35.50))
		.andExpect(jsonPath("$[0].curr").value("EUR"));
		//@formatter:on
	}

	@Test
	void when_getByQuery_expect_ok_case2() throws Exception {
		String url = String.format(BASE_URL, "2020-06-14T16:00:00", "35455", "1");
		//@formatter:off
		this.mockMvc.perform(get(url))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isNotEmpty())	
		.andExpect(jsonPath("$.length()").value(2))
		.andExpect(jsonPath("$[0].brandId").value(1))
		.andExpect(jsonPath("$[0].startDate").value("2020-06-14T00:00:00"))
		.andExpect(jsonPath("$[0].endDate").value("2020-12-31T23:59:59"))
		.andExpect(jsonPath("$[0].priceList").value(1))
		.andExpect(jsonPath("$[0].productId").value(35455))
		.andExpect(jsonPath("$[0].price").value(35.50))
		.andExpect(jsonPath("$[0].curr").value("EUR"))
		.andExpect(jsonPath("$[1].brandId").value(1))
		.andExpect(jsonPath("$[1].startDate").value("2020-06-14T15:00:00"))
		.andExpect(jsonPath("$[1].endDate").value("2020-06-14T18:30:00"))
		.andExpect(jsonPath("$[1].priceList").value(2))
		.andExpect(jsonPath("$[1].productId").value(35455))
		.andExpect(jsonPath("$[1].price").value(25.45))
		.andExpect(jsonPath("$[1].curr").value("EUR"));
		//@formatter:on
	}

	@Test
	void when_getByQuery_expect_ok_case3() throws Exception {
		String url = String.format(BASE_URL, "2020-06-14T21:00:00", "35455", "1");
		//@formatter:off
		this.mockMvc.perform(get(url))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isNotEmpty())	
		.andExpect(jsonPath("$.length()").value(1))
		.andExpect(jsonPath("$[0].brandId").value(1))
		.andExpect(jsonPath("$[0].startDate").value("2020-06-14T00:00:00"))
		.andExpect(jsonPath("$[0].endDate").value("2020-12-31T23:59:59"))
		.andExpect(jsonPath("$[0].priceList").value(1))
		.andExpect(jsonPath("$[0].productId").value(35455))
		.andExpect(jsonPath("$[0].price").value(35.50))
		.andExpect(jsonPath("$[0].curr").value("EUR"));
		//@formatter:on
	}

	@Test
	void when_getByQuery_expect_ok_case4() throws Exception {
		String url = String.format(BASE_URL, "2020-06-15T10:00:00", "35455", "1");
		//@formatter:off
		this.mockMvc.perform(get(url))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isNotEmpty())	
		.andExpect(jsonPath("$.length()").value(2))
		.andExpect(jsonPath("$[0].brandId").value(1))
		.andExpect(jsonPath("$[0].startDate").value("2020-06-14T00:00:00"))
		.andExpect(jsonPath("$[0].endDate").value("2020-12-31T23:59:59"))
		.andExpect(jsonPath("$[0].priceList").value(1))
		.andExpect(jsonPath("$[0].productId").value(35455))
		.andExpect(jsonPath("$[0].price").value(35.50))
		.andExpect(jsonPath("$[0].curr").value("EUR"))
		.andExpect(jsonPath("$[1].brandId").value(1))
		.andExpect(jsonPath("$[1].startDate").value("2020-06-15T00:00:00"))
		.andExpect(jsonPath("$[1].endDate").value("2020-06-15T11:00:00"))
		.andExpect(jsonPath("$[1].priceList").value(3))
		.andExpect(jsonPath("$[1].productId").value(35455))
		.andExpect(jsonPath("$[1].price").value(30.50))
		.andExpect(jsonPath("$[1].curr").value("EUR"));
		//@formatter:on
	}

	@Test
	void when_getByQuery_expect_ok_case5() throws Exception {
		String url = String.format(BASE_URL, "2020-06-16T21:00:00", "35455", "1");
		//@formatter:off
		this.mockMvc.perform(get(url))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isNotEmpty())	
		.andExpect(jsonPath("$.length()").value(2))
		.andExpect(jsonPath("$[0].brandId").value(1))
		.andExpect(jsonPath("$[0].startDate").value("2020-06-14T00:00:00"))
		.andExpect(jsonPath("$[0].endDate").value("2020-12-31T23:59:59"))
		.andExpect(jsonPath("$[0].priceList").value(1))
		.andExpect(jsonPath("$[0].productId").value(35455))
		.andExpect(jsonPath("$[0].price").value(35.50))
		.andExpect(jsonPath("$[0].curr").value("EUR"))
		.andExpect(jsonPath("$[1].brandId").value(1))
		.andExpect(jsonPath("$[1].startDate").value("2020-06-15T16:00:00"))
		.andExpect(jsonPath("$[1].endDate").value("2020-12-31T23:59:59"))
		.andExpect(jsonPath("$[1].priceList").value(4))
		.andExpect(jsonPath("$[1].productId").value(35455))
		.andExpect(jsonPath("$[1].price").value(38.95))
		.andExpect(jsonPath("$[1].curr").value("EUR"));
		//@formatter:on
	}
}
