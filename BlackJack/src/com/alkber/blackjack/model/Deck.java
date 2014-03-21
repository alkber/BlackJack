package com.alkber.blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/**
 * Models a deck of 52 cards also called the French deck
 * 
 * @author Althaf K Backer <althafkbacker@gmail.com>
 */
public class Deck {

	//private Random randomGenerator;
	private ArrayList<Card> aDeck;

	public Deck() {

		aDeck = new ArrayList<Card>();

		aDeck.add(new Card(11, "clubs", "Ace"));
		aDeck.add(new Card(11, "heart", "Ace"));
		aDeck.add(new Card(11, "diamond", "Ace"));
		aDeck.add(new Card(11, "spade", "Ace"));

		aDeck.add(new Card(10, "clubs", "King"));
		aDeck.add(new Card(10, "heart", "King"));
		aDeck.add(new Card(10, "diamond", "King"));
		aDeck.add(new Card(10, "spade", "King"));

		aDeck.add(new Card(10, "clubs", "Queen"));
		aDeck.add(new Card(10, "heart", "Queen"));
		aDeck.add(new Card(10, "diamond", "Queen"));
		aDeck.add(new Card(10, "spade", "Queen"));

		aDeck.add(new Card(10, "clubs", "Jack"));
		aDeck.add(new Card(10, "heart", "Jack"));
		aDeck.add(new Card(10, "diamond", "Jack"));
		aDeck.add(new Card(10, "spade", "Jack"));

		aDeck.add(new Card(2, "clubs", "2"));
		aDeck.add(new Card(2, "heart", "2"));
		aDeck.add(new Card(2, "diamond", "2"));
		aDeck.add(new Card(2, "spade", "2"));

		aDeck.add(new Card(3, "clubs", "3"));
		aDeck.add(new Card(3, "heart", "3"));
		aDeck.add(new Card(3, "diamond", "3"));
		aDeck.add(new Card(3, "spade", "3"));

		aDeck.add(new Card(4, "clubs", "4"));
		aDeck.add(new Card(4, "heart", "4"));
		aDeck.add(new Card(4, "diamond", "4"));
		aDeck.add(new Card(4, "spade", "4"));

		aDeck.add(new Card(5, "clubs", "5"));
		aDeck.add(new Card(5, "heart", "5"));
		aDeck.add(new Card(5, "diamond", "5"));
		aDeck.add(new Card(5, "spade", "5"));

		aDeck.add(new Card(6, "clubs", "6"));
		aDeck.add(new Card(6, "heart", "6"));
		aDeck.add(new Card(6, "diamond", "6"));
		aDeck.add(new Card(6, "spade", "6"));

		
		aDeck.add(new Card(7, "clubs", "7"));
		aDeck.add(new Card(7, "heart", "7"));
		aDeck.add(new Card(7, "diamond", "7"));
		aDeck.add(new Card(7, "spade", "7"));

		aDeck.add(new Card(8, "clubs", "8"));
		aDeck.add(new Card(8, "heart", "8"));
		aDeck.add(new Card(8, "diamond", "8"));
		aDeck.add(new Card(8, "spade", "8"));

		aDeck.add(new Card(9, "clubs", "9"));
		aDeck.add(new Card(9, "heart", "9"));
		aDeck.add(new Card(9, "diamond", "9"));
		aDeck.add(new Card(9, "spade", "9"));

		aDeck.add(new Card(10, "clubs", "10"));
		aDeck.add(new Card(10, "heart", "10"));
		aDeck.add(new Card(10, "diamond", "10"));
		aDeck.add(new Card(10, "spade", "10"));

		//randomGenerator = new Random();
	}
	/**
	 * Shuffle, the deck om a ramdom order
	 */
	public void shuffle() {

		Collections.shuffle(aDeck, new Random(System.nanoTime()));

	}
	/**
	 * Draw a card from top of the deck
	 * 
	 * @return Card
	 */
	public Card draw() {

		//int cardIndex = randomGenerator.nextInt(aDeck.size());
		Card card = aDeck.get(0);
		aDeck.remove(0);
		return card;

	}
	
	@Override
	public String toString() {

		return "Deck : " +aDeck; 
		
	}

}
