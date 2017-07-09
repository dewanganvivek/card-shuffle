package com.cisco.shuffle.card.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.shuffle.card.service.CardsService;
import com.cisco.shuffle.model.Card;
import com.cisco.shuffle.model.Deck;
import com.cisco.shuffle.model.ShuffleAlgo;

@RestController
@RequestMapping("/cards")
public class CardController {

	@Autowired
	private CardsService cardsService;

	@RequestMapping(value = "/getDeck", method = RequestMethod.GET)
	public ResponseEntity getDeck(@RequestParam("deckName") String deckName) {
		ResponseEntity response = null;
		Deck<Card> deck = cardsService.getDeck(deckName);
		if (deck == null) {
			response = new ResponseEntity("No deck available with name : " + deckName, HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity(deck, HttpStatus.OK);
		}

		return response;
	}

	@RequestMapping(value = "/createDeck", method = RequestMethod.GET)
	public ResponseEntity creatDeck(@RequestParam("deckName") String deckName) {
		ResponseEntity response = null;
		Deck<Card> deck = cardsService.createDeck(deckName);
		if (deck != null) {
			response = new ResponseEntity(deck, HttpStatus.OK);
		} else {
			response = new ResponseEntity("Could not create Deck due to some technical fault.",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@RequestMapping(value = "/deleteDeck", method = RequestMethod.GET)
	public ResponseEntity deleteDeck(@RequestParam("deckName") String deckName) {
		ResponseEntity response = null;
		Deck<Card> deck = cardsService.removeDeck(deckName);
		if (deck == null) {
			response = new ResponseEntity("No deck available with name : " + deckName + " to remove ",
					HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity(deck, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(value = "/shuffle", method = RequestMethod.PUT)
	public ResponseEntity shuffle(@RequestParam("deckName") String deckName, ShuffleAlgo shuffleAlgo) {
		ResponseEntity response = null;
		Deck<Card> deck = cardsService.getDeck(deckName);
		if (deck != null) {
			deck.setShuffleAlgorithm(shuffleAlgo);
			deck.shuffleDeck();
			response = new ResponseEntity(deck, HttpStatus.OK);
		} else {
			response = new ResponseEntity("No deck available with name : " + deckName + " to shuffle ",
					HttpStatus.NOT_FOUND);
		}
		return response;

	}

	@RequestMapping(value = "/allDecks", method = RequestMethod.GET)
	public ResponseEntity getAllDecks() {
		ResponseEntity response = null;
		Collection<Deck<Card>> allDecks = cardsService.getAllDecks();
		if (allDecks != null && !allDecks.isEmpty()) {
			response = new ResponseEntity(allDecks, HttpStatus.OK);
		} else {
			response = new ResponseEntity("No deck available.", HttpStatus.NO_CONTENT);
		}
		return response;
	}

	/*
	 * ===================== Setup Deck =====================
	 */

}
