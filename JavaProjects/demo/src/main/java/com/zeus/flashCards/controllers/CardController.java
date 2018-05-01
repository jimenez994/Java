package com.zeus.flashCards.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeus.flashCards.models.Card;
import com.zeus.flashCards.services.CardServices;
import com.zeus.flashCards.services.DeckServices;
import com.zeus.flashCards.services.UserServices;

@RestController
@RequestMapping("/card")
public class CardController {
	@Autowired 
	private CardServices cardServices;
	@Autowired 
	private DeckServices deckServices;
	@Autowired 
	private UserServices userServices;
	
	@GetMapping("allCards")
	public ArrayList<Card> all(){
		return cardServices.all();
	}
	

}
