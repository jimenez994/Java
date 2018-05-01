package com.zeus.flashCards.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.flashCards.repositories.DeckRepository;

@Service
public class DeckServices {
	
	@Autowired 
	private DeckRepository deckRepo;

}
