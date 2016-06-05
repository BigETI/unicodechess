
public enum EChessFigures {

	/**
	 * 
	 */
	KING('\u2654', '\u265a', "King"),

	/**
	 * 
	 */
	QUEEN('\u2655', '\u265b', "Queen"),

	/**
	 * 
	 */
	ROOK('\u2656', '\u265c', "Rook"),

	/**
	 * 
	 */
	BISHOP('\u2657', '\u265d', "Bishop"),

	/**
	 * 
	 */
	KNIGHT('\u2658', '\u265e', "Knight"),

	/**
	 * 
	 */
	PAWN('\u2659', '\u265f', "Pawn");

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
	 * Constructor
	 * 
	 * @param white_figure
	 *            White figure
	 * @param black_figure
	 *            Black figure
	 * @param name
	 *            Name
	 */
	EChessFigures(char white_figure, char black_figure, String name) {

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
}
