package cs213.chess.pieces;

import java.util.ArrayList;

/**
 * @author Bilal Quadri
 *
 */
public class Bishop extends Piece {

	/**
	 * @param color
	 * @param rank
	 * @param file
	 */
	public Bishop(char color, char rank, int file) {
		super(color, rank, file);
		this.symbol = 'B';
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
