package com.alkber.blackjack.controller.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.alkber.blackjack.model.Card;
import com.alkber.blackjack.model.Player;
import com.alkber.blackjack.model.PlayerStatus;
/**
 * Various controller functions to calibrate player status, find winning player
 * 
 * @author Althaf K Backer <althafkbacker@gmail.com>
 *
 */
public class PlayerCalibrator {

	private PlayerCalibrator() {
		
		/* Not meant for instantiation */
	}
	
	/**
	 * Re-Calibrate the player status
	 * 
	 * @param player
	 */
	public static void reCalibrateStatus(Player player) {

		int total = getPlayerTotal(player);

		player.getPlayerStatus().setTotal(total);

		if (total == 21) {

			player.getPlayerStatus().setStatusTitle("exactly 21");
			player.getPlayerStatus().setStatusValue(PlayerStatus.EXACTLY_21);

			return;
		}

		// If the player's total is less than 17, they "hit" (i.e. get dealt
		// another card from the top of the deck).
		if (total < 17) {

			player.getPlayerStatus().setStatusTitle("hit");
			player.getPlayerStatus().setStatusValue(PlayerStatus.HIT);

			return;
		}
		// If the player's total is 17 or greater, they "stick" (i.e. don't get
		// dealt another card).
		if (total < 21 && total >= 17) {

			player.getPlayerStatus().setStatusTitle("stick");
			player.getPlayerStatus().setStatusValue(PlayerStatus.STICK);

			return;

		}
		// If the player's total is greater than 21, they "go bust" (i.e. are
		// ejected from the game).
		if (total > 21) {

			player.getPlayerStatus().setStatusTitle("go bust");
			player.getPlayerStatus().setStatusValue(PlayerStatus.GO_BUST);

			return;

		}

	}

	/**
	 * At the end of the game, if the game has not finished due to a player
	 * hitting 21, the player with the total closest (but still under) 21 wins.
	 * 
	 * @param players
	 * @return ArrayList<Player> of winning players
	 */
	public static ArrayList<Player> findWinner(ArrayList<Player> players) {

		Map<Player, Integer> closeTo21List = new HashMap<Player, Integer>();
		ArrayList<Player> winners = new ArrayList<Player>();

		for (Player player : players) {

			int value = 21 - player.getPlayerStatus().getTotal();
			closeTo21List.put(player, value);

		}
		Integer min = Collections.min(closeTo21List.values());

		// Quick and dirty implementation , there are other smarter ways to do
		// this
		for (Player player : players) {

			// There could be a draw
			if (closeTo21List.get(player) == min) {

				winners.add(player);

			}

		}

		return winners;

	}
	/**
	 * Display all the player details
	 * @param players
	 */
	public static void printAllPlayerStatus(ArrayList<Player> players) {

		for (Player player : players) {

			System.out.println(player);

		}

	}
	/**
	 * Calculate the summation of card weights 
	 *  
	 * @param player
	 * @return
	 */
	private static int getPlayerTotal(Player player) {

		ArrayList<Card> cardsInHand = player.getCardsInHand();
		int total = 0;

		for (Card card : cardsInHand) {

			total = card.getValue() + total;

		}

		return total;

	}

}
