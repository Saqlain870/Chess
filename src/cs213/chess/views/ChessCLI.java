package cs213.chess.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import cs213.chess.controls.Board;
import cs213.chess.controls.Game;
import cs213.chess.exceptions.IllegalFileRankException;
import cs213.chess.pieces.Piece;

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
		
		Piece test = board.getPieceAt("h1");
		ArrayList<String> moves = test.getValidMoves();
		if (moves.isEmpty()) {
			System.out.println("No moves available for this piece.");
		} else {
			for (String move : moves) {
				System.out.println(move);
			}
		}
		
		if (1 > 0) { return; }
		
		
		board.getPieceAt("h1").getValidMoves();
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
