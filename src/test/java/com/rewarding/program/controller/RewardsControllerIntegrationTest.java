package com.rewarding.program.controller;

import com.rewarding.program.repository.CustomerRewardRepository;
import com.rewarding.program.service.RewardsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.rewarding.program.model.Customer;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class RewardsControllerIntegrationTest {

	@MockBean
	RewardsService rewardsService;

	@Autowired
	private MockMvc mockMvc;


	@Test
	void shouldGetUnsuccessfulCustomerRewardsSuccessful() throws Exception {
		List<Customer> customerList = new ArrayList<>();
		customerList.add(Mockito.mock(Customer.class));
		when(rewardsService.calculateRewardsForAllCustomers())
				.thenReturn(customerList);
		mockMvc.perform(get("/rewards"))
				.andDo(print())
				.andExpect(status().isNotFound());
	}

	@Test
	void shouldGetCustomerRewardById() throws Exception {
		Customer customer = Mockito.mock(Customer.class);
		when(rewardsService.calculateRewardsById(1))
				.thenReturn(customer);
		mockMvc.perform(get("/rewards?customerId=1"))
				.andDo(print())
				.andExpect(status().isNotFound());
	}

}
