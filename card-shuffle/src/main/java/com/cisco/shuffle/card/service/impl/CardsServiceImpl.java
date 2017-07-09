package com.cisco.shuffle.card.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.shuffle.card.repository.CardRepo;
import com.cisco.shuffle.card.service.CardsService;
import com.cisco.shuffle.model.Card;
import com.cisco.shuffle.model.Deck;

@Service
public class CardsServiceImpl implements CardsService {
	
	@Autowired
	CardRepo cardRepo;

	@Override
	public Deck<Card> getDeck(String deckName) {
		return cardRepo.getDeck(deckName);
	}

	@Override
	public Deck<Card> removeDeck(String deckName) {
		return cardRepo.removeDeck(deckName);
	}

	@Override
	public Deck<Card> createDeck(String deckName) {
		return cardRepo.createDeck(deckName);
	}

	@Override
	public Collection<Deck<Card>> getAllDecks() {
		return cardRepo.getAllDecks();
	}

}
