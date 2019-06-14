package Sudoku;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) throws FileNotFoundException {

		

//Beginning of game**************************************************************************

		Board sudoku = new Board();
		
		sudoku.initiateNewGame();
		
		do {
			sudoku.displayBoard();
			sudoku.inputCheck();
			sudoku.victoryCheck();
		} while (sudoku.isGameOver() == false); 			
		} 
	}