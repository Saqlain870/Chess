package cs213.chess.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cs213.chess.controls.Board;
import cs213.chess.controls.Game;

/**
 * @author bilalq
 *
 */
public class ChessCLI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game();
		Board board = game.getBoard();
		
		board.getPieceAt("a1").getValidMoves();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String line;
			try {
				line = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			
			System.out.println();
			System.out.println(board);
			System.out.print(game.getTurn() == 'w' ? "White's move: " : "Black's move: ");
			game.changeTurn();
		}
	}

}
