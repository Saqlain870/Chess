package cs213.chess.controls;

import cs213.chess.pieces.Piece;
import cs213.chess.pieces.Queen;

/**
 * 
 * @author Bilal Quadri
 *
 */
public class Game {

	private Board board;
	private char turn;
	private boolean drawRequested;
	
	
	/**
	 * Initialize the game by creating a new board.
	 * 
	 * The board layout is the default chess setup with white set to go first.
	 */
	public Game() {
		this.setBoard(new Board());
		this.turn = 'w';
		this.setDrawRequested(false);
	}
	
	/**
	 * Gets the character representing which player's turn it is.
	 * 
	 * @return 'w' if it's white's turn and 'b' if it's black's turn.
	 */
	public char getTurn() {
		return this.turn;
	}
	
	/**
	 * Change the turn from white to black and vice versa.
	 */
	public void changeTurn() {
		this.turn = (this.turn == 'w') ? 'b' : 'w';
	}
	

	/**
	 * Gets the board of this game.
	 * 
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	
	/**
	 * Sets the board.
	 * 
	 * @param board the board to set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * @return the drawRequested
	 */
	public boolean getDrawRequested() {
		return drawRequested;
	}

	/**
	 * @param drawRequested the drawRequested to set
	 */
	public void setDrawRequested(boolean drawRequested) {
		this.drawRequested = drawRequested;
	}

	public boolean currentPlayerHasLegalMoves() {
		Piece[][] pieces = this.board.getPieces();
		
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces[i].length; j++) {
				Piece piece = pieces[i][j];
				if (piece != null && piece.getColor() == this.turn && piece.canMove()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks if the board is in either checkmate or stalemate, and determines
	 * if the game is still active.
	 * 
	 * @return Whether or not the game is still ongoing.
	 */
	public boolean isActive() {
		return currentPlayerHasLegalMoves();
	}
	
	public boolean currentPlayerInCheck() {
		return (this.turn == 'w') ? this.board.whiteKingInDanger() : this.board.blackKingInDanger();
	}
	
	public boolean inCheckmate() {
		return (! isActive()) && currentPlayerInCheck();
	}
	
	public boolean inStalemate() {
		return ! (isActive() || currentPlayerInCheck());
	}
	
}
