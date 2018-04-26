package com.zeus.flashCards.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.flashCards.models.Deck;

@Repository
public interface DeckRepository extends CrudRepository<Deck, Long> {
	ArrayList<Deck> findAll();
}
