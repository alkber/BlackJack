package com.alkber.blackjack.model;
/**
 * Models a 'card' in a deck of cards
 * 
 * @author Althaf K Backer <althafkbacker@gmail.com>
 */
public class Card {

	private int value;
	private String suit;
	private String name;

	@Override
	public String toString() {

		return name + " " + suit;

	}

	public Card(int value, String suit, String name) {

		this.value = value;
		this.suit = suit;
		this.name = name;

	}

	public int getValue() {
	
		return value;

	}
	
}
