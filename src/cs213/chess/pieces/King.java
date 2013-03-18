package cs213.chess.pieces;

import java.util.ArrayList;

/**
 * @author Bilal Quadri
 *
 */
public class King extends Piece {

	/**
	 * Constructor for King.
	 * 
	 * @param color
	 * @param rank
	 * @param file
	 */
	public King(char color, char rank, int file) {
		super(color, rank, file);
		this.symbol = 'K';
	}

	/* (non-Javadoc)
	 * @see cs213.chess.pieces.Piece#getValidMoves()
	 */
	@Override
	public ArrayList<String> getValidMoves() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cs213.chess.pieces.Piece#canMoveTo(java.lang.String)
	 */
	@Override
	public boolean canMoveTo(String rankFile) {
		// TODO Auto-generated method stub
		return false;
	}

}
