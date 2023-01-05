package com.rewarding.program.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Table(name="Purchase_transaction")
@Getter
@Setter
public class Transaction {

	@Id
	private int id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

	@Column(name = "transaction_amount")
	int transactionAmount;

	@Column(name = "creation_date")
	Date creationDate;
}
