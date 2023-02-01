package com.mosby.security2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mosby.security2.entities.ContactMessage;

public interface ContactMessageRepository extends CrudRepository<ContactMessage	, Integer> {

	
}
