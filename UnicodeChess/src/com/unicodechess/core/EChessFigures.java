package com.unicodechess.core;

public enum EChessFigures {

	/**
	 * King
	 */
	KING('\u2654', '\u265a', "King", new AChessMovements() {
		{
			for (int i = -1, j; i < 2; i++) {
				for (j = -1; j < 2; j++) {
					if ((i != 0) || (j != 0))
						addMovement(i, j);
				}
			}
		}
	}),

	/**
	 * Queen
	 */
	QUEEN('\u2655', '\u265b', "Queen", new AChessMovements() {
		{
			for (int i = -7, j; i < 8; i++) {
				if (i == 0) {
					for (j = -7; j < 8; j++) {
						if (j != 0) {
							addMovement(j, j);
							addMovement(j, -j);
						}
					}
				} else {
					addMovement(i, 0);
					addMovement(0, i);
				}
			}
		}
	}),

	/**
	 * Rook
	 */
	ROOK('\u2656', '\u265c', "Rook", new AChessMovements() {
		{
			for (int i = -7; i < 8; i++) {
				if (i != 0) {
					addMovement(i, 0);
					addMovement(0, i);
				}
			}
		}
	}),

	/**
	 * Bishop
	 */
	BISHOP('\u2657', '\u265d', "Bishop", new AChessMovements() {
		{
			for (int i = -7; i < 8; i++) {
				if (i != 0) {
					addMovement(i, i);
					addMovement(i, -i);
				}
			}
		}
	}),

	/**
	 * Knight
	 */
	KNIGHT('\u2658', '\u265e', "Knight", new AChessMovements() {
		{
			skip_pieces = true;
			for (int i = 0, j; i < 2; i++) {
				for (j = 0; j < 2; j++) {
					addMovement((i == 0) ? 1 : -1, (j == 0) ? 2 : -2);
					addMovement((j == 0) ? 2 : -2, (i == 0) ? 1 : -1);
				}
			}
		}
	}),

	/**
	 * Pawn
	 */
	PAWN('\u2659', '\u265f', "Pawn", new AChessMovements() {
		{
			pawn_abilities = true;
			addMovement(0, 1);
			addMovement(0, -1);
		}
	});

	/**
	 * White figure
	 */
	private char white_figure;

	/**
	 * Black figure
	 */
	private char black_figure;

	/**
	 * Name
	 */
	private String name;

	/**
	 * Movements
	 */
	private AChessMovements movements;

	/**
	 * Constructor
	 * 
	 * @param white_figure
	 *            White figure
	 * @param black_figure
	 *            Black figure
	 * @param name
	 *            Name
	 */
	EChessFigures(char white_figure, char black_figure, String name, AChessMovements movements) {
		this.white_figure = white_figure;
		this.black_figure = black_figure;
		this.name = name;
		this.movements = movements;
	}

	/**
	 * Get white figure
	 * 
	 * @return White figure
	 */
	public char getWhiteFigure() {
		return white_figure;
	}

	/**
	 * Get black figure
	 * 
	 * @return Black figure
	 */
	public char getBlackFigure() {
		return black_figure;
	}

	/**
	 * Get name
	 * 
	 * @return Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get chess piece movements
	 * 
	 * @return Chess piece movements
	 */
	public AChessMovements getMovements() {
		return movements;
	}
}
