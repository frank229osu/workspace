import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class SudokuTest {

	@Test
	public void test_victory_conditions() {
		
		String[][] board = new String[9][9];		//board[row][column]
		
		board[0][0] = "5";
		board[0][1] = "8";
		board[0][2] = "1";
		board[0][3] = "4";
		board[0][4] = "2";
		board[0][5] = "7";
		board[0][6] = "6";
		board[0][7] = "9";
		board[0][8] = "3";
		board[1][0] = "3";
		board[1][1] = "7";
		board[1][2] = "4";
		board[1][3] = "5";
		board[1][4] = "9";
		board[1][5] = "6";
		board[1][6] = "8";
		board[1][7] = "1";
		board[1][8] = "2";
		board[2][0] = "9";
		board[2][1] = "6";
		board[2][2] = "2";
		board[2][3] = "1";
		board[2][4] = "3";
		board[2][5] = "8";
		board[2][6] = "4";
		board[2][7] = "7";
		board[2][8] = "5";
		board[3][0] = "6";
		board[3][1] = "2";
		board[3][2] = "9";
		board[3][3] = "3";
		board[3][4] = "8";
		board[3][5] = "5";
		board[3][6] = "7";
		board[3][7] = "4";
		board[3][8] = "1";
		board[4][0] = "1";
		board[4][1] = "5";
		board[4][2] = "7";
		board[4][3] = "9";
		board[4][4] = "6";
		board[4][5] = "4";
		board[4][6] = "3";
		board[4][7] = "2";
		board[4][8] = "8";
		board[5][0] = "8";
		board[5][1] = "4";
		board[5][2] = "3";
		board[5][3] = "2";
		board[5][4] = "7";
		board[5][5] = "1";
		board[5][6] = "5";
		board[5][7] = "6";
		board[5][8] = "9";
		board[6][0] = "4";
		board[6][1] = "1";
		board[6][2] = "8";
		board[6][3] = "7";
		board[6][4] = "5";
		board[6][5] = "2";
		board[6][6] = "9";
		board[6][7] = "3";
		board[6][8] = "6";
		board[7][0] = "2";
		board[7][1] = "9";
		board[7][2] = "5";
		board[7][3] = "6";
		board[7][4] = "4";
		board[7][5] = "3";
		board[7][6] = "1";
		board[7][7] = "8";
		board[7][8] = "7";
		board[8][0] = "7";
		board[8][1] = "3";
		board[8][2] = "6";
		board[8][3] = "8";
		board[8][4] = "1";
		board[8][5] = "9";
		board[8][6] = "2";
		board[8][7] = "5";
		board[8][8] = "4";
		
		List<String> victory = new ArrayList<String>();
		victory.add("1");
		victory.add("2");
		victory.add("3");
		victory.add("4");
		victory.add("5");
		victory.add("6");
		victory.add("7");
		victory.add("8");
		victory.add("9");
		
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
		
		Assert.assertTrue( h1.containsAll(victory) && h2.containsAll(victory) && h3.containsAll(victory) && 
			h4.containsAll(victory) && h5.containsAll(victory) && h6.containsAll(victory) && 
			h7.containsAll(victory) && h8.containsAll(victory) && h9.containsAll(victory) &&
			v1.containsAll(victory) && v2.containsAll(victory) && v3.containsAll(victory) && 
			v4.containsAll(victory) && v5.containsAll(victory) && v6.containsAll(victory) && 
			v7.containsAll(victory) && v8.containsAll(victory) && v9.containsAll(victory) && 
			boxA1.containsAll(victory) && boxA4.containsAll(victory) && boxA7.containsAll(victory) &&
			boxD1.containsAll(victory) && boxD4.containsAll(victory) && boxD7.containsAll(victory) &&
			boxG1.containsAll(victory) && boxG4.containsAll(victory) && boxG7.containsAll(victory) &&
			a1i9.containsAll(victory) && a9i1.containsAll(victory));	
	}

}
