package com.unicodechess.core;

public class ChessState {

	public final static ChessFigure[][] INITIALIZED_FIGURES = new ChessFigure[8][8];

	private ChessFigure[][] figures = null;

	static {
		for (int i = 0, j; i < 2; i++) {
			for (j = 0; j < 2; j++) {
				INITIALIZED_FIGURES[(j == 0) ? 0 : 7][i * 7] = new ChessFigure(EChessFigures.ROOK, i == 0);
				INITIALIZED_FIGURES[(j == 0) ? 1 : 6][i * 7] = new ChessFigure(EChessFigures.KNIGHT, i == 0);
				INITIALIZED_FIGURES[(j == 0) ? 2 : 5][i * 7] = new ChessFigure(EChessFigures.BISHOP, i == 0);
			}
			INITIALIZED_FIGURES[3][i * 7] = new ChessFigure(EChessFigures.QUEEN, i == 0);
			INITIALIZED_FIGURES[4][i * 7] = new ChessFigure(EChessFigures.KING, i == 0);
		}
		for (int i = 0; i < INITIALIZED_FIGURES.length; i++)
			INITIALIZED_FIGURES[i][1] = new ChessFigure(EChessFigures.PAWN, true);
		for (int i = 0; i < INITIALIZED_FIGURES.length; i++)
			INITIALIZED_FIGURES[i][1] = new ChessFigure(EChessFigures.PAWN, false);
	}

	public ChessState() {
		this(null);
		for (int i = 0, j; i < figures.length; i++) {
			for (j = 0; j < figures[i].length; j++) {
				figures[i][j] = (ChessFigure) figures[i][j].clone();
			}
		}
	}

	public ChessState(ChessState chess_state) {
		if (chess_state == null)
			figures = INITIALIZED_FIGURES.clone();
		else {
			figures = chess_state.figures.clone();
		}
		for (int i = 0, j; i < figures.length; i++) {
			for (j = 0; j < figures[i].length; j++) {
				if (figures[i][j] != null)
					figures[i][j] = (ChessFigure) figures[i][j].clone();
			}
		}
	}

	public boolean isPositionValid(int x, int y) {
		boolean ret = false;
		if ((x >= 0) && (x < figures.length)) {
			if ((y >= 0) && (y < figures[x].length))
				ret = true;
		}
		return ret;
	}
	
	public void setFigure(ChessFigure figure, int x, int y) {
		if (isPositionValid(x, y))
			figures[x][y] = figure;
	}

	public ChessFigure getFigure(int x, int y) {
		ChessFigure ret = null;
		if (isPositionValid(x, y))
			ret = figures[x][y];
		return ret;
	}

	public Object clone() {
		return new ChessState(this);
	}
}
