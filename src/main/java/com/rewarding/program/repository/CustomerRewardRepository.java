package com.rewarding.program.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rewarding.program.model.Customer;

@Repository
public interface CustomerRewardRepository extends JpaRepository<Customer, Integer>{

}
