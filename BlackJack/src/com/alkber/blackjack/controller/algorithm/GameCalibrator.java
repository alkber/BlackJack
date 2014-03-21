package com.alkber.blackjack.controller.algorithm;

import java.util.ArrayList;

import com.alkber.blackjack.model.Player;
import com.alkber.blackjack.model.PlayerStatus;

/**
 * Various controller functions to calibrate game status
 * 
 * @author Althaf K Backer <althafkbacker@gmail.com>
 * 
 */
public class GameCalibrator {

	private GameCalibrator() {

		/* Not meant for instantiation */

	}

	/**
	 * The game finishes if: a. All players "stick" in a round. b. Any player
	 * hits 21 exactly. c. There is only one player is left in the game because
	 * all others have "gone bust".
	 * 
	 * @return true if game finished else false
	 */
	public static boolean isGameFinished(ArrayList<Player> players) {

		int goneBustCnt = 0;
		int stickCnt = 0;

		for (Player current : players) {

			if (current.getPlayerStatus().getStatusValue() == PlayerStatus.EXACTLY_21) {

				System.out.println(" exactly 21 finish");
				// System.out.println(current);

				return true;

			}

			if (current.getPlayerStatus().getStatusValue() == PlayerStatus.STICK) {

				stickCnt++;
				if (stickCnt == players.size()) {

					System.out.println(" all players STICK, finish");
					return true;

				}

			}

			if (current.getPlayerStatus().getStatusValue() == PlayerStatus.GO_BUST) {

				goneBustCnt++;
				if ((players.size() - goneBustCnt) == 1) {

					System.out
							.println("one player left, all players GO BUST, finish");
					return true;

				}

			}

		}

		return false;
	}

}
