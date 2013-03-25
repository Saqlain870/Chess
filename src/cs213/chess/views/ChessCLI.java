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
 * @author Bilal Quadri
 *
 */
public class ChessCLI {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Game game = new Game();
		Board board = game.getBoard();
		
		Piece test = null;
		try {
			test = board.getPieceAt("a8");
			System.out.println(test.inDanger());
		} catch (IllegalFileRankException e) {}
//		try {
//			test = board.getPieceAt("b2");
//			ArrayList<String> moves = test.getValidMoves();
//			if (moves.isEmpty()) {
//				System.out.println("No moves available for this piece.");
//			} else {
//				for (String move : moves) {
//					System.out.println(move);
//				}
//			}
//		} catch (IllegalFileRankException e1) { e1.printStackTrace(); }
		if (1 > 0) { return; }
		
		
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
