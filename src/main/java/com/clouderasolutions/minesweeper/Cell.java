package com.clouderasolutions.minesweeper;

public class Cell {

	CellState cellState = CellState.UNCHECKED;
	boolean mined = false;
	int value = -1;

	static enum CellState {
		UNCHECKED, FLAGGED, OPENED;
	}

	@Override
	public String toString() {
		switch (cellState) {
		case FLAGGED:
			return "f";
		case OPENED:
			return String.valueOf(value);
		default:
			return "x";
		}
	}
}
