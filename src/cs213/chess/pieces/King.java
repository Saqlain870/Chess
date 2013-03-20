package cs213.chess.pieces;

import java.util.ArrayList;

import cs213.chess.controls.Board;

/**
 * @author Bilal Quadri
 *
 */
public class King extends Piece {
	
	private boolean inCheck;

	/**
	 * Constructor for King.
	 * 
	 * @param color
	 * @param file
	 * @param rank
	 * @param board
	 */
	public King(char color, char file, int rank, Board board) {
		super(color, file, rank, board);
		this.symbol = 'K';
		this.setInCheck(false);
	}

	/**
	 * Constructor for King.
	 * 
	 * @param color
	 * @param i
	 * @param j
	 * @param board
	 */
	public King(char color, int i, int j, Board board) {
		super(color, i, j, board);
		this.symbol = 'K';
		this.setInCheck(false);
	}
	
	/**
	 * @return Whether or not this king is in check.
	 */
	public boolean isInCheck() {
		return inCheck;
	}

	/**
	 * @param Change the check status of this king.
	 */
	public void setInCheck(boolean inCheck) {
		this.inCheck = inCheck;
	}

	/* (non-Javadoc)
	 * @see cs213.chess.pieces.Piece#getValidMoves()
	 */
	@Override
	public ArrayList<String> getValidMoves() {
		ArrayList<String> validMoves = new ArrayList<String>();
		
		// Check for castling options
		if (canKingSideCastle()) {
			validMoves.add("g" + this.rank);
		}
		if (canQueenSideCastle()) {
			validMoves.add("c" + this.rank);
		}
		
		// TODO figure out the rest of it's legal moves
		return validMoves;
	}

	public boolean canKingSideCastle() {
		return false;
	}
	
	public boolean canQueenSideCastle() {
		return false;
	}

}
