package com.unicodechess.core;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

public abstract class AChessMovements {

	protected ArrayList<AbstractMap.SimpleEntry<Integer, Integer>> movements = new ArrayList<>();

	protected boolean skip_pieces = false;

	protected boolean pawn_abilities = false;

	protected void addMovement(int x, int y) {
		movements.add(new AbstractMap.SimpleEntry<Integer, Integer>(x, y));
	}

	@SuppressWarnings("unchecked")
	public AbstractMap.SimpleEntry<Integer, Integer>[] getMoves() {
		return (SimpleEntry<Integer, Integer>[]) movements.toArray();
	}

	public boolean canSkipPieces() {
		return skip_pieces;
	}

	public boolean hasPawnAbilities() {
		return pawn_abilities;
	}
}
