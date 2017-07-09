package com.cisco.shuffle;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.cisco.shuffle.model.Card;
import com.cisco.shuffle.model.CardImpl;

public class Card_Spec{
  final static Logger logger = Logger.getLogger(Card_Spec.class);
  @Test
  public void Testing_Card_Gets(){
    logger.info("=====");
    logger.info("Testing Card POJO Gets() ");
    logger.info("=====");
    Card card = new CardImpl("2","heart",2,4);
    logger.info("\tCard Value:"  + card.getCardValue());
    logger.info("\tCard Suit :"  + card.getSuit());
    logger.info("\tCard Suit Priority :" + card.getSuitPriority());
    logger.info("\tCard Card Priority:" + card.getCardPriority());
    assertEquals(card.getCardValue(),"2");
    assertEquals(card.getSuit(),"heart");
    assertEquals(card.getCardPriority(),2);
    assertEquals(card.getSuitPriority(),4);
  }
}
