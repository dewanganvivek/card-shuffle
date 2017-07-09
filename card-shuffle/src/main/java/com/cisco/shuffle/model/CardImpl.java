package com.cisco.shuffle.model;

public class CardImpl implements Card {
	private String cardValue;
	private String suit;
	private int cardPriority;
	private int suitPriority;

	// default constructor
	public CardImpl() {

	}

	public CardImpl(String cardValue, String suit, int cardPriority, int suitPriority) {
		this.cardValue = cardValue;
		this.suit = suit;
		this.cardPriority = cardPriority;
		this.suitPriority = suitPriority;
	}

	public int setCardPriority(int priority) {
		this.cardPriority = priority;
		return this.cardPriority;
	}

	public int getCardPriority() {
		return this.cardPriority;
	}

	public int setSuitPriority(int suitPriority) {
		this.suitPriority = suitPriority;
		return this.suitPriority;
	}

	public int getSuitPriority() {
		return this.suitPriority;
	}

	public String setCardValue(String cardValue) {
		this.cardValue = cardValue;
		return this.cardValue;
	}

	public String getCardValue() {
		return this.cardValue;
	}

	public String setSuit(String suit) {
		this.suit = suit;
		return this.suit;
	}

	public String getSuit() {
		return this.suit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cardPriority;
		result = prime * result + ((cardValue == null) ? 0 : cardValue.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + suitPriority;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardImpl other = (CardImpl) obj;
		if (cardPriority != other.cardPriority)
			return false;
		if (cardValue == null) {
			if (other.cardValue != null)
				return false;
		} else if (!cardValue.equals(other.cardValue))
			return false;
		if (suit == null) {
			if (other.suit != null)
				return false;
		} else if (!suit.equals(other.suit))
			return false;
		if (suitPriority != other.suitPriority)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CardImpl [cardValue=" + cardValue + ", suit=" + suit + ", cardPriority=" + cardPriority
				+ ", suitPriority=" + suitPriority + "]";
	}

}
