package Sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

	//Data Members*****************************************************************************************************
	Board newSudoku = new Board();
	Scanner myKeyboard = new Scanner(System.in);
	
	
	//CTOR***********************************************************************************************************
	public Game() throws FileNotFoundException {
		File game = new File("rules.txt");
		
		try(Scanner gameScanner = new Scanner(game)){
			while(gameScanner.hasNextLine()) {
				String line = gameScanner.nextLine();
				System.out.println(line);
			}
		}		
				
				
		boolean gameExists = false;
		
		game = new File("gameNew.txt");
		
		List<String> startConditions = new ArrayList<String>();
		
		try(Scanner gameScanner = new Scanner(game)){
			while(gameScanner.hasNextLine()) {
				String line = gameScanner.nextLine();
				newSudoku.setBoard(line);
			}
		}
		
		do {
			System.out.println("\nWhat game would you like to load? : (game1)");
			
			String playerInput = myKeyboard.nextLine()+".txt";
			game = new File(playerInput);
		
		if(game.exists()) {
		
		try(Scanner gameScanner = new Scanner(game)){
			while(gameScanner.hasNextLine()) {
				String line = gameScanner.nextLine();
				newSudoku.setBoard(line);
				//board[Integer.parseInt(splitter[0])][Integer.parseInt(splitter[1])] ="{" + splitter[2] + "}";
				startConditions.add(line.substring(0, 2));
			}
		}
		gameExists = true;
		} else {
			System.out.printf("%s does not exist, please try again.", playerInput);
		}
	} 		while(gameExists == false);}
	
	//Get-set**********************************************************************************************************
	
	
	//Methods************************************************************************************************************
	
	
	
}
