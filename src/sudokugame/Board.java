package sudokugame;

import java.util.Scanner;

public class Board {
	private int[][] gameBoard;
	private String fileName;
	
	public Board(String fileName) {
		this.fileName = fileName;
		// Loading gameBoard from text file
		int[][] gameBoard = new int[9][9];
	}
	
	public void loadSudokuFromFile(String fileName) {
		Scanner scan = new Scanner(fileName);
		
		int col = 0;
		while(scan.hasNext()) {
			String currLine = scan.nextLine();
			String[] currLineAsArr = currLine.split(" ");
			
			for(int i = 0; i < 9; i++) {
				String currChar = currLineAsArr[i];
				int currVal = Integer.parseInt(currChar);
				
				gameBoard[i][col] = currVal;
			}
			
			col++;
		}
		
	}
	
	public String toString() {
		String output = "";
		return output;
	}
}