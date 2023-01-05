package com.rewarding.program.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Table(name="Customer")
@Getter
@Setter
public class Customer{
	public Customer(int id, String name, Set<Transaction> transactions,
					int firstMonthRewards, int secondMonthRewards, int thirdMonthRewards, int totalRewardAmount) {
		this.id = id;
		this.name = name;
		this.transactions = transactions;
		this.firstMonthRewards = firstMonthRewards;
		this.secondMonthRewards = secondMonthRewards;
		this.thirdMonthRewards = thirdMonthRewards;
		this.totalRewardAmount = totalRewardAmount;
	}

	@Id
	int id;

	@Column
	String name;

	@JsonIgnore
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Transaction> transactions;
	
	@Transient
	int firstMonthRewards;
	
	@Transient
	int secondMonthRewards;
	
	@Transient
	int thirdMonthRewards;
	
	@Transient
	int totalRewardAmount;

	public Customer() {

	}
}
