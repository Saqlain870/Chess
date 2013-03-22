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
		// The king cannot have moved or be in check
		if (this.hasMoved() || this.isInCheck()) {
			return false;
		}
		
		// The spaces in between the king and the rook must be empty
		if (this.board.getPieceAt("f" + this.rank) != null 
				|| this.board.getPieceAt("g" + this.rank) != null) {
			return false;
		}
		
		// TODO: Check if f1/f8 and g1/g8 are in danger
		
		// The rook must be at the end and it cannot have moved
		Piece rook = this.board.getPieceAt("h" + this.rank);
		if (rook == null || rook.getClass() != Rook.class || rook.hasMoved()) {
			return false;
		}
		
		return true;
	}
	
	public boolean canQueenSideCastle() {
		// The king cannot have moved or be in check
		if (this.hasMoved() || this.isInCheck()) {
			return false;
		}
		
		// The spaces in between the king and the rook must be empty
		if (this.board.getPieceAt("b" + this.rank) != null 
				|| this.board.getPieceAt("c" + this.rank) != null
				|| this.board.getPieceAt("d" + this.rank) != null) {
			return false;
		}
		
		// TODO: Check if the c1/c8 and d1/d8 are in danger
		
		Piece rook = this.board.getPieceAt("a" + this.rank);
		if (rook == null || rook.getClass() != Rook.class || rook.hasMoved()) {
			return false;
		}
		
		return true;
	}

}
