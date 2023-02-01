package com.mosby.security2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mosby.security2.entities.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

	Account findByUserId(Integer userId);
}
