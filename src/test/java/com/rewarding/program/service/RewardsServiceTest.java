package com.rewarding.program.service;

import com.rewarding.program.RewardsUtil;
import com.rewarding.program.model.Customer;
import com.rewarding.program.repository.CustomerRewardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RewardsServiceTest {

    @InjectMocks
    RewardsService rewardsService;

    @Mock
    RewardsUtil rewardsUtil;

    @Mock
    CustomerRewardRepository customerRewardRepo;

    @Test
    @DisplayName("Test calculate rewards for transactions amount below fifty")
    void testCalculateRewardsForTransactionsAmountBelowFifty() {
        when(customerRewardRepo.findById(1)).thenReturn(Optional.of(new Customer(
                1, "Mike", new HashSet<>(), 0,0,40,40 )));
        Customer customer = rewardsService.calculateRewardsById(1);
        if (customer.getId() == 1) {
            Assertions.assertEquals(40, customer.getTotalRewardAmount());
        }
    }

    @Test
    @DisplayName("Test calculate rewards for transactions amount above fifty below one hundred")
    void testCalculateRewardsForTransactionsAmountAboveFiftyBelowOneHundred() {
        when(customerRewardRepo.findById(3)).thenReturn(Optional.of(new Customer(
                3, "Mike", new HashSet<>(), 0,0,70,70 )));
        Customer customer = rewardsService.calculateRewardsById(3);
        if (customer.getId() == 3) {
            Assertions.assertEquals(70, customer.getTotalRewardAmount());
        }
    }

    @Test
    @DisplayName("Test calculate rewards for transactions amount one hundred")
    void testCalculateRewardsForTransactionsAmountOneHundred() {
        when(customerRewardRepo.findById(7)).thenReturn(Optional.of(new Customer(
                7, "Mike", new HashSet<>(), 0,0,100,100 )));
        Customer customer = rewardsService.calculateRewardsById(7);
        if (customer.getId() == 7) {
            Assertions.assertEquals(100, customer.getTotalRewardAmount());
        }
    }

    @Test
    @DisplayName("Test calculate rewards for transactions amount above one hundred")
    void testCalculateRewardsForTransactionsAmountAboveOneHundred() {
        when(customerRewardRepo.findById(4)).thenReturn(Optional.of(new Customer(
                4, "Mike", new HashSet<>(), 0,50,70,120 )));
        Customer customer = rewardsService.calculateRewardsById(4);
        if (customer.getId() == 4) {
            Assertions.assertEquals(120, customer.getTotalRewardAmount());
        }
    }

    @Test
    @DisplayName("Test calculate rewards for past date, expected 0 as result")
    void testCalculateRewardsForPastDate() {
        when(customerRewardRepo.findById(6)).thenReturn(Optional.of(new Customer(
                6, "Mike", new HashSet<>(), 0,0,0,0 )));
        Customer customer = rewardsService.calculateRewardsById(6);
        if (customer.getId() == 6) {
            Assertions.assertEquals(0, customer.getTotalRewardAmount());
        }
    }

}
