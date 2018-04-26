package com.zeus.flashCards.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.flashCards.models.Card;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
	ArrayList<Card> findAll();
}
