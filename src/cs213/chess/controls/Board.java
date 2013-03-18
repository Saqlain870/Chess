package cs213.chess.controls;

import cs213.chess.pieces.Piece;

/**
 * @author bilalq
 *
 */
public class Board {

	private Piece[][] pieces;
	
	public Board() {
		this.setPieces(null);
	}

	/**
	 * @return the pieces
	 */
	public Piece[][] getPieces() {
		return pieces;
	}

	/**
	 * @param pieces the pieces to set
	 */
	public void setPieces(Piece[][] pieces) {
		this.pieces = pieces;
	}
}
