package com.cisco.shuffle.model;

import org.springframework.stereotype.Component;

@Component
public interface Card extends Suit {
	public int setCardPriority(int priority);

	public int getCardPriority();

	public String setCardValue(String cardValue);

	public String getCardValue();
}
