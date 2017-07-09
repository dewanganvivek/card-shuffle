package com.cisco.shuffle.card.repository.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cisco.shuffle.card.repository.CardRepo;
import com.cisco.shuffle.model.Card;
import com.cisco.shuffle.model.CardImpl;
import com.cisco.shuffle.model.Deck;
import com.cisco.shuffle.model.ShuffleAlgo;

@Repository
public class CardRepoImpl implements CardRepo {

	private static HashMap<String, Deck<Card>> decks = new HashMap<>();

	@Override
	public Deck<Card> getDeck(String deckName) {
		Deck<Card> deck = null;
		if (!decks.isEmpty()) {
			deck = decks.get("deck_" + deckName);
		}
		return deck;
	}

	@Override
	public Deck<Card> removeDeck(String deckName) {
		Deck<Card> deck = null;
		if (!decks.isEmpty()) {
			deck = decks.remove("deck_" + deckName);
		}
		return deck;
	}

	@Override
	public Deck<Card> createDeck(String deckName) {
		Deck<Card> deck = null;
		if (!decks.isEmpty()) {
			deck = decks.get("deck_" + deckName);
			if (deck == null) {
				deck = new Deck<Card>(setupDeck(), ShuffleAlgo.DEFAULT_SHUFFLE);
				decks.put("deck_" + deckName, deck);
			}
		}
		return deck;
	}

	@Override
	public Collection<Deck<Card>> getAllDecks() {
		Collection<Deck<Card>> allDecks = null;
		if (!decks.isEmpty()) {
			allDecks = decks.values();
		}
		return allDecks;
	}

	private List<Card> setupDeck() {
		List<Card> llist = new LinkedList<Card>();
		String[] faceCards = { "J", "Q", "K", "A" };
		String[] suits = { "spades", "clubs", "diamonds", "hearts" };

		for (int i = 2; i <= 10; i++) {
			for (int j = 1; j <= 4; j++) {
				llist.add(new CardImpl(Integer.toString(i), suits[j - 1], j, i));
			}
		}
		for (int k = 1; k <= 4; k++) {
			for (int l = 1; l <= 4; l++) {
				llist.add(new CardImpl(faceCards[k - 1], suits[l - 1], l, k + 10));
			}
		}
		return llist;
	}

}
