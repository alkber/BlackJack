package com.alkber.blackjack.model;
/**
 * Models various player states, altered by <code>PlayerCalibrator</code>
 * 
 * @author Althaf K Backer <althafkbacker@gmail.com>
 */
public class PlayerStatus {

	public static final int WINNER = 0;
	public static final int HIT = 1;
	public static final int STICK = 2;
	public static final int GO_BUST = 3;
	public static final int EXACTLY_21 = 4;

	private int total;
	private int statusValue;
	private String statusTitle;

	@Override
	public String toString() {
		
		return "Total: "+total +" " +statusTitle;
				
	}
	public int getStatusValue() {
		
		return statusValue;
		
	}

	public void setStatusValue(int statusValue) {
		
		this.statusValue = statusValue;
		
	}

	public PlayerStatus() {

	}

	public int getTotal() {
		
		return total;
		
	}

	public void setTotal(int total) {
		
		this.total = total;
		
	}

	public String getStatusTitle() {
		
		return statusTitle;
		
	}

	public void setStatusTitle(String statusTitle) {
		
		this.statusTitle = statusTitle;
		
	}

}
