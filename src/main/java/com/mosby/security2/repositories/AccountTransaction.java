package com.mosby.security2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AccountTransaction extends CrudRepository<AccountTransaction, Integer> {

	List<AccountTransaction> findByUserIdOrderByTransactionDtDesc(Integer userId);
}
