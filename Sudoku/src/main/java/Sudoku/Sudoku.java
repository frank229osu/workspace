package Sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

import java.util.Map;

import java.util.Scanner;

public class Sudoku {

	public static void main(String[] args) throws FileNotFoundException {

		

//Beginning of game**************************************************************************

		Board sudoku = new Board();
		
		sudoku.initiateNewGame();
		
		do {
			sudoku.displayBoard();
			sudoku.inputCheck();
			sudoku.testVictoryConditions();
			sudoku.displayBoard();
			sudoku.victoryCheck();
			
			boolean playAgain = false;
			
			do {			
			System.out.println("Would you like to play another game? (y/n)");
			Scanner playerInput = new Scanner(System.in);
			String value = playerInput.nextLine();
			
			if (value.equals("y")) {
				playAgain = true;
			} else if (playerInput.equals("n")) {
				playAgain = false;
			}
			}while (playAgain == false);
			
		} while (sudoku.isGameOver() == false);

		System.out.println("Thank you for playing!");
		
		
	}}