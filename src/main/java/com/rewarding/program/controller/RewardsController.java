package com.rewarding.program.controller;

import java.util.List;

import com.rewarding.program.exception.CustomParameterConstraintException;
import com.rewarding.program.exception.CustomerNotFoundException;
import com.rewarding.program.service.RewardsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rewarding.program.model.Customer;

@RestController
@RequestMapping("/rewards")
@Slf4j
public class RewardsController {

	private final RewardsService rewardsService;

	public RewardsController(RewardsService rewardsService) {
		Assert.notNull(rewardsService,"RewardsService must not be null");
		this.rewardsService = rewardsService;
	}

	@GetMapping(value="/all")
    public ResponseEntity<Object> getCustomerRewards() {
		log.info("In RewardsController::getCustomerRewards method start");
		List<Customer> customerList = rewardsService.calculateRewardsForAllCustomers();

		if (CollectionUtils.isEmpty(customerList)) {
			log.error("In RewardsController::getCustomerRewards Customer List is empty");
			throw new CustomerNotFoundException("No Customers found");
		}

		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}
	
	@GetMapping(value="/{customerId}")
    public ResponseEntity<Customer> getCustomerRewardById(@PathVariable Integer customerId) {
		log.info("In RewardsController::getCustomerRewardById method start");
		if(customerId == 0)
		{
			log.error("In RewardsController::getCustomerRewardById customerId is 0");
			throw new CustomParameterConstraintException("Customer with Id::::" + customerId + " does not exist");
		}
		Customer customer = rewardsService.calculateRewardsById(customerId);
		
		if (customer == null) {
			log.error("In RewardsController::getCustomerRewardById No Customer Record Found");
			throw new CustomerNotFoundException("Customer with Id::::" + customerId + " does not exist");
		}
		
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
}
