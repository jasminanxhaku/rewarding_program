package com.rewarding.program.controller;

import com.rewarding.program.model.Customer;
import com.rewarding.program.service.RewardsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


class RewardsControllerUnitTest {

    @Test
    void shouldGetCustomerRewards()
    {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(Mockito.mock(Customer.class));
        RewardsService rewardsService = Mockito.mock(RewardsService.class);
        when(rewardsService.calculateRewardsForAllCustomers()).thenReturn(customerList);
        RewardsController rewardsController = new RewardsController(rewardsService);
        assertEquals(new ResponseEntity<>(customerList, HttpStatus.OK), rewardsController.getCustomerRewards());
    }

    @Test
    void shouldGetCustomerRewardById()
    {
        Customer customer = Mockito.mock(Customer.class);
        RewardsService rewardsService = Mockito.mock(RewardsService.class);
        when(rewardsService.calculateRewardsById(1)).thenReturn(customer);
        RewardsController rewardsController = new RewardsController(rewardsService);
        assertEquals(new ResponseEntity<>(customer, HttpStatus.OK), rewardsController.getCustomerRewardById(1));
    }

}

