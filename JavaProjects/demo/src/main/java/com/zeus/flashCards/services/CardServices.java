package com.zeus.flashCards.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.flashCards.models.Card;
import com.zeus.flashCards.repositories.CardRepository;

@Service
public class CardServices {
	
	@Autowired 
	private CardRepository cardRepo;
	
	public ArrayList<Card> all(){
		return cardRepo.findAll();
	}

}
