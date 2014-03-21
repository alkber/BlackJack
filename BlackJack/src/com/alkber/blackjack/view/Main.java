package com.alkber.blackjack.view;

import java.util.ArrayList;

import com.alkber.blackjack.controller.algorithm.GameCalibrator;
import com.alkber.blackjack.controller.algorithm.PlayerCalibrator;
import com.alkber.blackjack.model.Deck;
import com.alkber.blackjack.model.Player;
import com.alkber.blackjack.model.PlayerStatus;
/**
 * Main view of the Black Jack Game
 * 
 * @author Althaf K Backer <althafkbacker@gmail.com>
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		int playerCnt = 0;
		ArrayList<Player> players = new ArrayList<Player>();
		Deck aDeck = new Deck();
		
		if (args.length != 2) {

			System.out.println("bj -np <player count>");
			System.exit(0);

		} else {

			if (args[0].equals("-np")) {

				try {

					playerCnt = Integer.valueOf(args[1]);

					if (playerCnt <= 1 || playerCnt > 6) {
					
						throw new NumberFormatException();

					}

				} catch (NumberFormatException e) {

					System.out.println("-np (np > 1 and np <= 6)");
					System.exit(0);
					
				}

			} else {

				System.out.println("expects, -np <player count>");
				System.exit(0);

			}

		}



		System.out.println("x^x^x BLACK JACK x^x^x");
		System.out.println("-----------------------");
		System.out.println("Card Deck : 1");
		System.out.println("Shuffling Deck...");
		aDeck.shuffle();
		System.out.println(aDeck);
		System.out.println("-----------------------");
		System.out.println("Total Players : " + playerCnt);
		System.out.println("-----------------------");
		for (int i = 0; i < playerCnt; i++) {

			Player current = new Player("Player " + (i + 1));
			players.add(current);
			current.insertCard(aDeck.draw());
			current.insertCard(aDeck.draw());
			PlayerCalibrator.reCalibrateStatus(current);
			System.out.println(current);

		}

		int playerIndex = 0;

		while (true) {

			System.out.println("-----------------------");
			System.out.print("Game status,");
			// each iteration checks for game finish status
			if (GameCalibrator.isGameFinished(players)) {

				System.out.println("-----------------------");
				ArrayList<Player> winners = PlayerCalibrator
						.findWinner(players);
				System.out.println("-----------------------");
				System.out.println("Winning Players");
				System.out.println("-----------------------");

				for (Player player : winners) {

					System.out.println(player);

				}

				System.out.println("-----------------------");
				System.out.println("Final Player States");
				System.out.println("-----------------------");
				PlayerCalibrator.printAllPlayerStatus(players);
				System.out.println("-----------------------");
				System.out.println("Frooday (c) 2014");
				System.out.println("Althaf <althafkbacker@cluncle.com>");				
				System.out.println("-----------------------");
				return;

			} else {

				System.out.println(" , continue");

			}
			System.out.println("-----------------------");

			if (playerIndex == playerCnt) {

				playerIndex = 0;

			}

			Player current = players.get(playerIndex);
			System.out.println("Turn " + current.getPlayerName());
			System.out.println("Current Status " + current);

			switch (current.getPlayerStatus().getStatusValue()) {
			
			case PlayerStatus.STICK:
				//Player idle 			
				System.out.println("Not drawing card, status STICK");
				break;
			case PlayerStatus.GO_BUST:
				//Player ejected
				System.out.println("Not drawing card, status GO BUST");
				System.out.println("Player ejected");
				players.remove(playerIndex);
				playerCnt--;
				break;
			
			default:
				System.out.println("Draw, a card.. ");
				current.insertCard(aDeck.draw());
				PlayerCalibrator.reCalibrateStatus(current);

			}

			Thread.sleep(5000);
			playerIndex++;

		}
	}
}
