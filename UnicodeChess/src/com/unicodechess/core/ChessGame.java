package com.unicodechess.core;

import java.util.Stack;

public class ChessGame {
	
	private Stack<ChessMoveState> move_states = new Stack<>();
	
	public ChessGame() {
		move_states.push(ChessMoveState.getInitialMoveState());
	}
	
	public ChessMoveState getMoveState() {
		return move_states.peek();
	}
	
	public ChessMoveState revertMoveState() {
		ChessMoveState ret = null;
		if (!(move_states.isEmpty())) {
			move_states.pop();
			ret = move_states.peek();
		}
		return ret;
	}
}
