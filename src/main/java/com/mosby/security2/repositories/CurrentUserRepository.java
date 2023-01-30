package com.mosby.security2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mosby.security2.entities.CurrentUser;

public interface CurrentUserRepository extends CrudRepository<CurrentUser, Integer> {
	List<CurrentUser> findByEmail(String email);
}
