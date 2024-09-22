package com.systex.service;




public class GuessGame {
	private int remains;
	private int luckyNumber;
	public GuessGame(int range,int remains) {
		// TODO Auto-generated constructor stub
		this.remains=remains;
		setLuckyNumber(range);
	}
	private void setLuckyNumber(int range) {
		this.luckyNumber = (int)(Math.random()*range)+1;
		System.out.println("luckyNumber"+luckyNumber);
	}
	public int getRemains() {
		return remains;
	}
	public int getLuckyNumber() {
		return luckyNumber;
	}
	public boolean Guess(int number) {
		boolean result= number==luckyNumber;
		if(result==false) {
			remains--;
		}
		return result;
	}
	
}
