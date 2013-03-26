package cs213.chess.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import cs213.chess.controls.Board;
import cs213.chess.controls.Game;
import cs213.chess.exceptions.IllegalColorException;
import cs213.chess.exceptions.IllegalFileRankException;
import cs213.chess.exceptions.IllegalMoveException;
import cs213.chess.pieces.*;

/**
 * @author Bilal Quadri
 *
 */
public class Chess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Game game = new Game();
		Board board = game.getBoard();
		
		boolean firstRun = true;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(game.isActive()) {
			if (firstRun) {
				printPrompt(game);
				firstRun = false;
			}
			
			String line;
			try {
				line = reader.readLine();
				if (line == null) {
					continue;
				}
				line.trim();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
			
			// Check for resignation
			if (line.equals("resign")) {
				game.changeTurn();
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
			
			if (tokens.length >= 3) {
				String promotionType = tokens[2];
				if (promotionType.equals("B")) {
					board.setPromotionType(Bishop.class);
				} else if (promotionType.equals("N")) {
					board.setPromotionType(Knight.class);
				} else if (promotionType.equals("R")) {
					board.setPromotionType(Rook.class);
				} else {
					board.setPromotionType(Queen.class);
				}
			}
			
			if (tokens.length < 2) {
				System.out.println("That is an invalid command. Please try again");
				continue;
			}
			
			try {
				board.makeMove(game.getTurn(), tokens[0], tokens[1]);
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
						if (legalMoves.isEmpty()) {
							System.out.println("(None)");
						}
						System.out.print(game.getTurn() == 'w' ? "White's move: " : "Black's move: ");
					}
				} catch (IllegalFileRankException e1) {}
			} catch (IllegalFileRankException e) {
				System.out.println("One or more of the FileRanks specified is invalid.");
				System.out.print(game.getTurn() == 'w' ? "White's move: " : "Black's move: ");
			} catch (IllegalColorException e) {
				System.out.println("\n" + e.getMessage());
				System.out.print(game.getTurn() == 'w' ? "White's move: " : "Black's move: ");
			}
			
		}
		if (game.inCheckmate()) {
			game.changeTurn();
			System.out.println("Checkmate");
			printWinner(game.getTurn());
		} else if (game.inStalemate()) {
			System.out.println("Stalemate");
		}
	}
	
	public static void printPrompt(Game game) {
			Board board = game.getBoard();
			System.out.println();
			System.out.println(board);
			if (game.currentPlayerInCheck()) {
				System.out.println("Check !");
			}
			System.out.print(game.getTurn() == 'w' ? "White's move: " : "Black's move: ");
	}
	
	public static void printWinner(char color) {
		String fullColor;
		fullColor = (color == 'w') ? "White" : "Black";
		System.out.println(fullColor + " wins");
	}

}
