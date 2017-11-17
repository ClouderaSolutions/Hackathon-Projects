package com.clouderasolutions.minesweeper;

import java.util.Scanner;

public class MineSweeperGame {

	/*
	 * Comment
	 */
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		System.out.println("Enter Board size with space \n");
		int m = scr.nextInt();
		int n = scr.nextInt();
		Board board = new Board(m, n);
		board.initBoard();
		while (!board.isGameOver()) {
			System.out.println("Enter option 1-open, 2-flag: \n");
			int option = scr.nextInt();
			System.out.println("Enter coordinates with space separated\n");
			int x = scr.nextInt();
			int y = scr.nextInt();
			if (1 == option) {
				if (!board.openCell(x, y)) {
					System.out.println("Game Over\n");
					board.display();
					break;
				}
			}
			else if (2 == option) {
				board.flagCell(x, y);
				
			}
			else {
				System.out.println("wrong option\n");
			}
			board.display();
		}
		scr.close();
	}
}
