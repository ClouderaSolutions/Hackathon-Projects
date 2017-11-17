package com.clouderasolutions.minesweeper;

import com.clouderasolutions.minesweeper.Cell.CellState;

public class Board {

	Cell[][] cells = null;
	int m;
	int n;

	public Board(int m, int n) {
		this.m = m;
		this.n = n;
		cells = new Cell[m][n];
	}

	boolean openCell(int x, int y) {
		if (cells[x - 1][y - 1].mined) {
			return false;
		}
		cells[x - 1][y - 1].cellState = CellState.OPENED;
		return true;
	}

	void flagCell(int x, int y) {
		cells[x - 1][y - 1].cellState = CellState.FLAGGED;
	}

	void initBoard() {
		for (int i = 0; i < m; i++) {
			int randomNumber = randomWithRange(1,m);
			for (int j = 0; j < n; j++) {
				Cell cell = new Cell();
				if (randomNumber == j) {
					cell.mined = true;
				}
				cells[i][j] = cell;
			}
		}
		fillValues();
	}
	
	int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
	private void fillValues() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!cells[i][j].mined) {
					cells[i][j].value = getMinesCount(i, j);
				}
			}
		}
	}

	private int getMinesCount(int i, int j) {
		int count = 0;
		for (int k = i - 1; k <= i + 1; k++) {
			for (int l = j - 1; l <= j + 1; l++) {
				if (k == i && l == j) {
					continue;
				}
				if ((k >= 0 && k < m) && (l >= 0 && l < n)) {
					if (cells[k][l].mined) {
						count++;
					}
				}
			}
		}
		return count;
	}

	public void display() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(cells[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean isGameOver() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (cells[i][j].cellState == CellState.UNCHECKED || (cells[i][j].cellState == CellState.FLAGGED && !cells[i][j].mined)) {
					return false;
				}
			}
		}
		return true;
	}
}
