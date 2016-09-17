package com.unicodechess.core;

public class ChessMove {

	private int x;

	private int y;

	private int move_x;

	private int move_y;
	
	public ChessMove(int x, int y, int move_x, int move_y) {
		this.x = x;
		this.y = y;
		this.move_x = move_x;
		this.move_y = move_y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getMoveX() {
		return move_x;
	}
	
	public int getMoveY() {
		return move_y;
	}
	
	public int getNextX() {
		return x + move_x;
	}
	
	public int getNextY() {
		return y + move_y;
	}
}
