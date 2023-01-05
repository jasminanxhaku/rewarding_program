package com.rewarding.program.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.rewarding.program.RewardsUtil;
import com.rewarding.program.model.Customer;
import com.rewarding.program.model.Transaction;
import com.rewarding.program.repository.CustomerRewardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
public class RewardsService {

	private final CustomerRewardRepository customerRewardRepo;

	private final RewardsUtil rewardsUtil;

	public RewardsService(CustomerRewardRepository customerRewardRepo, RewardsUtil rewardsUtil) {
		Assert.notNull(customerRewardRepo, "CustomerRewardRepo must not be null");
		Assert.notNull(rewardsUtil,"RewardsUtil must not be null");
		this.customerRewardRepo = customerRewardRepo;
		this.rewardsUtil = rewardsUtil;
	}

	public List<Customer> calculateRewardsForAllCustomers() {
		log.info("calculateRewardsForAllCustomers method In RewardService start");

		List<Customer> customerList = customerRewardRepo.findAll();
		if (!CollectionUtils.isEmpty(customerList)) {
			for (Customer customer : customerList) {
				log.debug("Calculating rewards for Each Customer:::::" + customer.getName());
				Set<Transaction> transactions = customer.getTransactions();
				setRewardsPerMonth(transactions, customer);
				log.debug("End of reward calculation for customer" + customer.getName());
			}

		}

		log.info("calculateRewardsForAllCustomers method in RewardService end");
		return customerList;
	}

	public Customer calculateRewardsById(Integer customerId) {
		log.info("calculateRewardsById method In RewardService start");
		
		Customer customerReward = customerRewardRepo.findById(customerId).orElse(null);
		if(customerReward != null) {
			log.debug("Calculating rewards for Each Customer:::::" + customerReward.getName());
			Set<Transaction> transactions = customerReward.getTransactions();
			setRewardsPerMonth(transactions, customerReward);
			log.debug("End of reward calculation for customer" + customerReward.getName());
		}
		
		log.info("calculateRewardsById method In RewardService end");
		return customerReward;
	}
	
	private void setRewardsPerMonth(Set<Transaction> transactions, Customer customer) {

		LocalDate todayDate = LocalDate.now();

		for (Transaction transaction : transactions) {
			log.debug("Start Calculating Rewards for Customer:::" + customer.getName() + "and for Transaction Id::: "
					+ transaction.getId());

			int transactionMonth = transaction.getCreationDate().toLocalDate().getMonthValue();
			int transactionYear = transaction.getCreationDate().toLocalDate().getYear();

			int rewards = rewardsUtil.calculateRewardPointsPerTrans(transaction.getTransactionAmount());

			if ((todayDate.minusMonths(2).getYear() == transactionYear)
					&& (todayDate.minusMonths(2).getMonth().getValue() == transactionMonth))
				customer.setFirstMonthRewards(customer.getFirstMonthRewards() + rewards);

			else if ((todayDate.minusMonths(1).getYear() == transactionYear)
					&& (todayDate.minusMonths(1).getMonth().getValue() == transactionMonth))
				customer.setSecondMonthRewards(customer.getSecondMonthRewards() + rewards);

			else if ((todayDate.getYear() == transactionYear) && (todayDate.getMonth().getValue() == transactionMonth))
				customer.setThirdMonthRewards(customer.getThirdMonthRewards() + rewards);

			customer.setTotalRewardAmount(customer.getFirstMonthRewards() +
					customer.getSecondMonthRewards() + customer.getThirdMonthRewards());

			log.debug("End Calculating Rewards for Customer::::" + customer.getName() + "and for Transaction Id:::"
					+ transaction.getId());

		}
	}

}
