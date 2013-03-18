package cs213.chess.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cs213.chess.controls.Board;

/**
 * @author Bilal Quadri
 *
 */
public class Game {

	private Board board;
	
	/**
	 * Initialize the game by creating a new board.
	 */
	public Game() {
		this.setBoard(new Board());
	}
	
	/**
	 * Main method for running the game.
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String line;
			try {
				line = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			
			System.out.println(line);
		}
	}

	/**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * @param board the board to set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}

}
