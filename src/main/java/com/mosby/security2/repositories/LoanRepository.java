package com.mosby.security2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mosby.security2.entities.Loan;

public interface LoanRepository extends CrudRepository<Loan, Integer> {

	List<Loan> findByUserIdOrderByStartDtDesc(Integer userId);
}
