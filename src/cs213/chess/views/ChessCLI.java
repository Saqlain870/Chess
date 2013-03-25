package cs213.chess.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import cs213.chess.controls.Board;
import cs213.chess.controls.Game;
import cs213.chess.exceptions.IllegalFileRankException;
import cs213.chess.exceptions.IllegalMoveException;
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
		
//		Piece test = null;
//		try {
//			test = board.getPieceAt("d1");
//			System.out.println(test.inDanger());
//		} catch (IllegalFileRankException e) {}
////		try {
////			test = board.getPieceAt("b2");
////			ArrayList<String> moves = test.getValidMoves();
////			if (moves.isEmpty()) {
////				System.out.println("No moves available for this piece.");
////			} else {
////				for (String move : moves) {
////					System.out.println(move);
////				}
////			}
////		} catch (IllegalFileRankException e1) { e1.printStackTrace(); }
//		if (1 > 0) { return; }
		
		boolean firstRun = true;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			if (firstRun) {
				printPrompt(game);
				firstRun = false;
			}
			
			String line;
			try {
				line = reader.readLine().trim();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			
			// Check for resignation
			if (line.equals("resign")) {
				printWinner(game.getTurn());
				System.exit(0);
			}
			
			// Check for draw
			if (line.equals("draw") || line.equals("draws")) {
				if (game.getDrawRequested()) {
					System.out.println("Draw");
					System.exit(0);
				}
			}
			
			// Update draw request
			game.setDrawRequested(line.endsWith("draw?"));
			
			// Make move
			String[] tokens = line.split(" ");
			if (tokens.length < 2) {
				System.out.println("That is an invalid command. Please try again");
				continue;
			}
			
			try {
				board.makeMove(tokens[0], tokens[1]);
				game.changeTurn();
				printPrompt(game);
			} catch (IllegalMoveException e) {
				System.out.println("\n" + e.getMessage());
				try {
					Piece chosen = board.getPieceAt(tokens[0]);
					if (chosen != null) {
						ArrayList<String> legalMoves = chosen.getLegalMoves();
						System.out.println("Legal moves for this piece: ");
						for (String move : legalMoves) {
							System.out.println(chosen.getFileRank() + " " + move);
						}
						System.out.print(game.getTurn() == 'w' ? "White's move: " : "Black's move: ");
					}
				} catch (IllegalFileRankException e1) {}
			} catch (IllegalFileRankException e) {
				System.out.println("One or more of the FileRanks specified is invalid.");
				System.out.print(game.getTurn() == 'w' ? "White's move: " : "Black's move: ");
			}
			
		}
	}
	
	public static void printPrompt(Game game) {
			Board board = game.getBoard();
			System.out.println();
			System.out.println(board);
			System.out.print(game.getTurn() == 'w' ? "White's move: " : "Black's move: ");
	}
	
	public static void printWinner(char color) {
		String fullColor;
		fullColor = (color == 'w') ? "White" : "Black";
		System.out.println(fullColor + " wins");
	}

}
