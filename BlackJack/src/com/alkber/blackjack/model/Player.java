package com.alkber.blackjack.model;

import java.util.ArrayList;
/**
 * Models a player in the game
 * 
 * @author Althaf K Backer <althafkbacker@gmail.com>
 */
public class Player {
	
	private String playerName;
	private ArrayList<Card> cardsInHand;
	private PlayerStatus playerStatus;
	
	public Player(String playerName) {
		
		this.playerName = playerName;
		this.cardsInHand = new ArrayList<Card>();
		this.playerStatus = new PlayerStatus();
		
	}
	
	public ArrayList<Card> getCardsInHand() {
		
		return cardsInHand;
		
	}
	
	public void insertCard(Card card) {
		
		cardsInHand.add(card);
		
	}

	@Override
	public String toString() {
		
		return playerName + " : "+cardsInHand + "\n" + " \\_status >" + playerStatus;
		
	}
	
	public PlayerStatus getPlayerStatus() {
		
		return playerStatus;
	
	}
	
	public String getPlayerName() {

		return playerName;
	
	}
}
