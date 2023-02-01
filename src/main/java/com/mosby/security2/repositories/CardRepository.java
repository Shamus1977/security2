package com.mosby.security2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mosby.security2.entities.Card;

public interface CardRepository extends CrudRepository<Card, Integer>{

	List<Card> findByUserId(Integer userId);
}
