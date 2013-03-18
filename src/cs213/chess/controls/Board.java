package cs213.chess.controls;

import cs213.chess.exceptions.IllegalCoordsException;
import cs213.chess.pieces.Piece;
import cs213.chess.utils.Helper;

/**
 * @author Bilal Quadri
 *
 */
public class Board {

	private Piece[][] pieces;
	
	
	/**
	 * Initializes the board with pieces in their default locations.
	 */
	public Board() {
		this.pieces = new Piece[8][8];
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

	
	/**
	 * Turn the board into a string that can be displayed in the command line.
	 */
	@Override
	public String toString() {
		String display = "";
		
		for (int i = 0; i < pieces.length; i++) {
			for (int j = 0; j < pieces.length; j++) {
				Piece piece = pieces[i][j];
				if (piece == null) {
					try {
						display += Helper.getSquareRepresentation(i, j);
					} catch (IllegalCoordsException e) {
						e.printStackTrace();
						System.out.println("Board is in an invalid state");
					}
				} else {
					display += piece.getIdentifier();
				}
				display += " ";
			}
			display += "\n";
		}
		
		return display;
	}
	
}
