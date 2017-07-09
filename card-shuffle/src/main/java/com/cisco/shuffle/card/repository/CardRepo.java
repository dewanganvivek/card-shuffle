package com.cisco.shuffle.card.repository;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.cisco.shuffle.model.Card;
import com.cisco.shuffle.model.Deck;

@Component
public interface CardRepo {
	public Deck<Card> getDeck(String deckName);

	public Deck<Card> removeDeck(String deckName);

	public Deck<Card> createDeck(String deckName);

	public Collection<Deck<Card>> getAllDecks();
}
