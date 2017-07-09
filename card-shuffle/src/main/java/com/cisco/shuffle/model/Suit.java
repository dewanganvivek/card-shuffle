package com.cisco.shuffle.model;

import org.springframework.stereotype.Component;

@Component
interface Suit {
	public String setSuit(String suit);

	public String getSuit();

	public int setSuitPriority(int suitPriority);

	public int getSuitPriority();
}
