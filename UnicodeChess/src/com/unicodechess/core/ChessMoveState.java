package com.unicodechess.core;

import java.util.AbstractMap;
import java.util.ArrayList;

public class ChessMoveState {

	private ChessState state;

	private ChessMove move;

	private ChessFigure transformation;

	public ChessMoveState(ChessState state, ChessMove move, ChessFigure transformation) {
		this.state = state;
		this.move = move;
		this.transformation = transformation;
	}

	public ChessState getState() {
		return state;
	}

	public ChessMove getMove() {
		return move;
	}

	public ChessFigure getTransformation() {
		return transformation;
	}

	public ChessMoveState emulateMove(ChessMove move, ChessFigure transformation) {
		ChessMoveState ret = null;
		if (move != null) {
			ChessState state = (ChessState) this.state.clone();
			ChessFigure figure = state.getFigure(move.getX(), move.getY());
			if (figure != null) {
				if (state.isPositionValid(move.getNextX(), move.getNextY())) {
					ChessFigure enemy = state.getFigure(move.getNextX(), move.getNextY());
					boolean allow_move = true;
					if (enemy != null) {
						if (enemy.isWhite() == figure.isWhite())
							allow_move = false;
					}
					if (allow_move) {
						state.setFigure(figure, move.getNextX(), move.getNextY());
						state.setFigure(null, move.getX(), move.getY());
						if (figure.getFigure().getMovements().hasPawnAbilities()) {
							if (figure.isWhite() ? (move.getNextY() == 7) : (move.getNextY() == 0))
								ret = new ChessMoveState(state, move, transformation);
							else
								ret = new ChessMoveState(state, move, null);
						} else
							ret = new ChessMoveState(state, move, null);
					}
				}
			}
		}
		return ret;
	}

	public ChessMoveState[] getPossibileMoveSates(int x, int y) {
		ChessMoveState[] ret = null;
		ChessFigure figure = state.getFigure(x, y);
		if (figure != null) {
			AChessMovements movements = figure.getFigure().getMovements();
			ArrayList<ChessMoveState> possible_move_states = new ArrayList<>();
			if (movements.hasPawnAbilities()) {
				for (AbstractMap.SimpleEntry<Integer, Integer> i : movements.getMoves()) {
					if (figure.isWhite() ? (i.getValue() > 0) : (i.getValue() < 0)) {
						ChessMoveState tms = emulateMove(new ChessMove(x, y, i.getKey(), i.getValue()), null);
						if (tms != null)
							possible_move_states.add(tms);
					}
				}
				if (figure.firstMove()) {
					for (AbstractMap.SimpleEntry<Integer, Integer> i : movements.getMoves()) {
						if (figure.isWhite() ? (i.getValue() > 0) : (i.getValue() < 0)) {
							ChessMoveState tms = emulateMove(new ChessMove(x, y, i.getKey(), i.getValue() * 2), null);
							if (tms != null)
								possible_move_states.add(tms);
						}
					}
				}
			} else {
				for (AbstractMap.SimpleEntry<Integer, Integer> i : movements.getMoves()) {
					ChessMoveState tms = emulateMove(new ChessMove(x, y, i.getKey(), i.getValue()), null);
					if (tms != null)
						possible_move_states.add(tms);
				}
			}
			if (!(possible_move_states.isEmpty()))
				ret = (ChessMoveState[]) possible_move_states.toArray();
		}
		return ret;
	}

	public static ChessMoveState getInitialMoveState() {
		return new ChessMoveState(new ChessState(), null, null);
	}
}
