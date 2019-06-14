package Sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Board {
	
	//Data Members*****************************************************************************************************
	String[][] board = new String[9][9];		//board[row][column]
	Map<Character, Integer> rowLetterToInt = new HashMap <Character, Integer>();
	Map<Character, Integer> columnLetterToInt = new HashMap <Character, Integer>();
	List<String> victory = new ArrayList<String>();
	Scanner myKeyboard = new Scanner(System.in);
	List<String> startConditions = new ArrayList<String>();
	boolean gameOver;
	
	//Horizontal victory conditions
	List<String> h1 = new ArrayList<String>();
	List<String> h2 = new ArrayList<String>();
	List<String> h3 = new ArrayList<String>();
	List<String> h4 = new ArrayList<String>();
	List<String> h5 = new ArrayList<String>();
	List<String> h6 = new ArrayList<String>();
	List<String> h7 = new ArrayList<String>();
	List<String> h8 = new ArrayList<String>();
	List<String> h9 = new ArrayList<String>();

	//Vertical victory conditions
	List<String> v1 = new ArrayList<String>();
	List<String> v2 = new ArrayList<String>();
	List<String> v3 = new ArrayList<String>();
	List<String> v4 = new ArrayList<String>();
	List<String> v5 = new ArrayList<String>();
	List<String> v6 = new ArrayList<String>();
	List<String> v7 = new ArrayList<String>();
	List<String> v8 = new ArrayList<String>();
	List<String> v9 = new ArrayList<String>();

	//Diagonal victory conditions
	List<String> a1i9 = new ArrayList<String>();
	List<String> a9i1 = new ArrayList<String>();

	//Box victory conditions - Box identified in list name will start with upper left most box. 
	List<String> boxA1 = new ArrayList<String>();
	List<String> boxA4 = new ArrayList<String>();
	List<String> boxA7 = new ArrayList<String>();
	List<String> boxD1 = new ArrayList<String>();
	List<String> boxD4 = new ArrayList<String>();
	List<String> boxD7 = new ArrayList<String>();
	List<String> boxG1 = new ArrayList<String>();
	List<String> boxG4 = new ArrayList<String>();
	List<String> boxG7 = new ArrayList<String>();
	
	//CTOR***********************************************************************************************************
	public Board() throws FileNotFoundException {
		gameOver = false;
		
		rowLetterToInt.put('a', 0);
		rowLetterToInt.put('b', 1);
		rowLetterToInt.put('c', 2);
		rowLetterToInt.put('d', 3);
		rowLetterToInt.put('e', 4);
		rowLetterToInt.put('f', 5);
		rowLetterToInt.put('g', 6);
		rowLetterToInt.put('h', 7);
		rowLetterToInt.put('i', 8);
		
		columnLetterToInt.put('1', 0);
		columnLetterToInt.put('2', 1);
		columnLetterToInt.put('3', 2);
		columnLetterToInt.put('4', 3);
		columnLetterToInt.put('5', 4);
		columnLetterToInt.put('6', 5);
		columnLetterToInt.put('7', 6);
		columnLetterToInt.put('8', 7);
		columnLetterToInt.put('9', 8);
		
		victory.add("1");
		victory.add("2");
		victory.add("3");
		victory.add("4");
		victory.add("5");
		victory.add("6");
		victory.add("7");
		victory.add("8");
		victory.add("9");		
}
			
	//Get-set**********************************************************************************************************
	
	public String getBoard(int i, int j) {
		return board[i][j];
	}

	public void setBoard(String line) {
		String[] splitter = line.split("");
		this.board[Integer.parseInt(splitter[0])][Integer.parseInt(splitter[1])] ="[" + splitter[2] + "]";
		
	}
	
	public void setBoardInitial(String line) {
		String[] splitter = line.split("");
		this.board[Integer.parseInt(splitter[0])][Integer.parseInt(splitter[1])] ="{" + splitter[2] + "}";
		
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	//Methods************************************************************************************************************

	public void initiateNewGame() throws FileNotFoundException {
		File game = new File("rules.txt");
		startConditions.clear();
		gameOver = false;
		
		try(Scanner gameScanner = new Scanner(game)){
			while(gameScanner.hasNextLine()) {
				String line = gameScanner.nextLine();
				System.out.println(line);
			}
		}		
				
		boolean gameExists = false;
		
		game = new File("gameNew.txt");
		
		try(Scanner gameScanner = new Scanner(game)){
			while(gameScanner.hasNextLine()) {
				String line = gameScanner.nextLine();
				setBoard(line);
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
				setBoardInitial(line);
				startConditions.add(line.substring(0, 2));
			}
		}
		gameExists = true;
		} else {
			System.out.printf("%s does not exist, please try again.", playerInput);
		}
	} 		while(gameExists == false);
	}
	
	public void displayBoard() {
		System.out.println("  *  1   2   3  *  4   5   6  *  7   8   9");
		System.out.println("*******************************************");
		System.out.printf("a * %s %s %s * %s %s %s * %s %s %s \n", 
			getBoard(0,0), getBoard(0,1), getBoard(0,2),
			getBoard(0,3), getBoard(0,4), getBoard(0,5),
			getBoard(0,6), getBoard(0,7), getBoard(0,8));
		
		System.out.printf("b * %s %s %s * %s %s %s * %s %s %s \n", 
			getBoard(1,0), getBoard(1,1), getBoard(1,2),
			getBoard(1,3), getBoard(1,4), getBoard(1,5),
			getBoard(1,6), getBoard(1,7), getBoard(1,8));

		System.out.printf("c * %s %s %s * %s %s %s * %s %s %s \n", 
			getBoard(2,0), getBoard(2,1), getBoard(2,2),
			getBoard(2,3), getBoard(2,4), getBoard(2,5),
			getBoard(2,6), getBoard(2,7), getBoard(2,8));
			
		System.out.println("*******************************************");

		System.out.printf("d * %s %s %s * %s %s %s * %s %s %s \n", 
			getBoard(3,0), getBoard(3,1), getBoard(3,2),
			getBoard(3,3), getBoard(3,4), getBoard(3,5),
			getBoard(3,6), getBoard(3,7), getBoard(3,8));

		System.out.printf("e * %s %s %s * %s %s %s * %s %s %s \n", 
			getBoard(4,0), getBoard(4,1), getBoard(4,2),
			getBoard(4,3), getBoard(4,4), getBoard(4,5),
			getBoard(4,6), getBoard(4,7), getBoard(4,8));
		
		System.out.printf("f * %s %s %s * %s %s %s * %s %s %s \n", 
			getBoard(5,0), getBoard(5,1), getBoard(5,2),
			getBoard(5,3), getBoard(5,4), getBoard(5,5),
			getBoard(5,6), getBoard(5,7), getBoard(5,8));

		System.out.println("*******************************************");

		System.out.printf("g * %s %s %s * %s %s %s * %s %s %s \n", 
			getBoard(6,0), getBoard(6,1), getBoard(6,2),
			getBoard(6,3), getBoard(6,4), getBoard(6,5),
			getBoard(6,6), getBoard(6,7), getBoard(6,8));

		System.out.printf("h * %s %s %s * %s %s %s * %s %s %s \n", 
			getBoard(7,0), getBoard(7,1), getBoard(7,2),
			getBoard(7,3), getBoard(7,4), getBoard(7,5),
			getBoard(7,6), getBoard(7,7), getBoard(7,8));

		System.out.printf("i * %s %s %s * %s %s %s * %s %s %s \n",
			getBoard(8,0), getBoard(8,1), getBoard(8,2),
			getBoard(8,3), getBoard(8,4), getBoard(8,5),
			getBoard(8,6), getBoard(8,7), getBoard(8,8));
	}

	public void inputCheck() {
		boolean validInput = false;
		
		do {
			System.out.println("Please enter a row letter (a-j) & column number (1-9) ex: a1");

			String locationInput = myKeyboard.nextLine();
			
			if (locationInput.length() == 1) {
				System.out.println("You entered: " + locationInput);
				System.out.println("2 characters are required. Try again");
			} else {

			char rowInput = locationInput.charAt(0);

			char columnInput = locationInput.charAt(1);
			
			System.out.println("Please enter the value you wish to insert (1-9):");
			
			String valueInput = myKeyboard.nextLine();

			System.out.printf("User entered location: %c%c & value: %s\n",rowInput, columnInput, valueInput);
	
			if(!rowLetterToInt.containsKey(rowInput) || !columnLetterToInt.containsKey(columnInput)) {
				System.out.println("Invalid input. Quit typing like Ginzo!");
			} else {
				if(startConditions.contains(rowLetterToInt.get(rowInput).toString() + columnLetterToInt.get(columnInput).toString())){
					System.out.println("Cannot modify a starting board condition");
				} else {
					board[rowLetterToInt.get(rowInput)][columnLetterToInt.get(columnInput)] = "[" + valueInput + "]";
					validInput = true;
					}
	
						}}
		} while(validInput = false);
		}
	
	public void victoryCheck() {
		
		h1.clear();
		h2.clear();
		h3.clear();
		h4.clear();
		h5.clear();
		h6.clear();
		h7.clear();
		h8.clear();
		h9.clear();
		v1.clear();
		v2.clear();
		v3.clear();
		v4.clear();
		v5.clear();
		v6.clear();
		v7.clear();
		v8.clear();
		v9.clear();
		a1i9.clear();
		a9i1.clear();
		boxA1.clear();
		boxA4.clear();
		boxA7.clear();
		boxD1.clear();
		boxD4.clear();
		boxD7.clear();
		boxG1.clear();
		boxG4.clear();
		boxG7.clear();
		
		for(int i = 0; i < 9; i++) {
			h1.add(board[0][i]);
			h2.add(board[1][i]);
			h3.add(board[2][i]);
			h4.add(board[3][i]);
			h5.add(board[4][i]);
			h6.add(board[5][i]);
			h7.add(board[6][i]);
			h8.add(board[7][i]);
			h9.add(board[8][i]);
			v1.add(board[i][0]);
			v2.add(board[i][1]);
			v3.add(board[i][2]);
			v4.add(board[i][3]);
			v5.add(board[i][4]);
			v6.add(board[i][5]);
			v7.add(board[i][6]);
			v8.add(board[i][7]);
			v9.add(board[i][8]);
			a1i9.add(board[i][i]);
	}

		for(int i = 8; i > -1; i--) {
			a9i1.add(board[i][i]);
		}

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				boxA1.add(board[i][j]);
				boxA4.add(board[i][j + 3]);
				boxA7.add(board[i][j + 6]);
				boxD1.add(board[i + 3][j]);
				boxD4.add(board[i + 3][j + 3]);
				boxD7.add(board[i + 3][j + 6]);
				boxG1.add(board[i + 6][j]);
				boxG4.add(board[i + 6][j + 3]);
				boxG7.add(board[i + 6][j + 6]);
			}
		}
		
		if (h1.containsAll(victory) && h2.containsAll(victory) && h3.containsAll(victory) && 
			h4.containsAll(victory) && h5.containsAll(victory) && h6.containsAll(victory) && 
			h7.containsAll(victory) && h8.containsAll(victory) && h9.containsAll(victory) &&
			v1.containsAll(victory) && v2.containsAll(victory) && v3.containsAll(victory) && 
			v4.containsAll(victory) && v5.containsAll(victory) && v6.containsAll(victory) && 
			v7.containsAll(victory) && v8.containsAll(victory) && v9.containsAll(victory) && 
			boxA1.containsAll(victory) && boxA4.containsAll(victory) && boxA7.containsAll(victory) &&
			boxD1.containsAll(victory) && boxD4.containsAll(victory) && boxD7.containsAll(victory) &&
			boxG1.containsAll(victory) && boxG4.containsAll(victory) && boxG7.containsAll(victory) &&
			a1i9.containsAll(victory) && a9i1.containsAll(victory)) {
		System.out.println("Congratulations! You solved the puzzle.");	
		gameOver = true;
		}
	}
}
