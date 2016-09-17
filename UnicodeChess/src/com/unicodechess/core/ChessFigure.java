package com.unicodechess.core;

public class ChessFigure {

	private EChessFigures figure;

	private boolean white;

	private boolean first_move = true;

	public ChessFigure(EChessFigures figure, boolean white) {
		this.figure = figure;
		this.white = white;
	}

	public EChessFigures getFigure() {
		return figure;
	}

	public boolean isWhite() {
		return white;
	}

	public boolean firstMove() {
		return first_move;
	}

	public void setMoved() {
		first_move = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "" + (white ? figure.getWhiteFigure() : figure.getBlackFigure());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone() {
		ChessFigure ret = new ChessFigure(figure, white);
		ret.first_move = first_move;
		return ret;
	}
}
