package sudokugame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Board {
	private int[][] gameBoard;
	private String fileName;
	
	public Board(String fileName) {
		this.fileName = fileName;
		// Loading gameBoard from text file
		
		gameBoard = new int[9][9];
		loadSudokuFromFile(fileName);
	}
	
	/**
	 * Helper function to load a sudoku base game from file.
	 * Expects each row of the sudoku board to be space-delimited
	 * @param fileName
	 */
	public void loadSudokuFromFile(String fileName) {
		File f = new File(fileName);
		
		Scanner scan;
		try {
			scan = new Scanner(f);
			int col = 0;
			while(scan.hasNext()) {
				String currLine = scan.nextLine();
				String[] currLineAsArr = currLine.split(" ");
				System.out.println(currLine);
				for(int i = 0; i < 9; i++) {
					String currChar = currLineAsArr[i];
					int currVal = Integer.parseInt(currChar);
					
					gameBoard[i][col] = currVal;
				}
				
				col++;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void addNumberToBoard(int xIndex, int yIndex, int value) {
		gameBoard[xIndex][yIndex] = value;
	}
	
	public int getValAtXY(int x, int y) {
		return gameBoard[x][y];
	}
	
	public String toString() {
		String output = "";
		
		for(int i = 0; i < 9 ; i++) {
			for(int j = 0; j < 9; j++) {
				output += gameBoard[i][j] + " ";
			}
			output += "\n";
		}
		return output;
	}
	
	public static void main(String[] args) {
		Board b = new Board("assets/sudokugrid.txt");
		b.toString();
	}
}