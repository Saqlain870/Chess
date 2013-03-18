package cs213.chess.pieces;

import java.util.ArrayList;

/**
 * @author Bilal Quadri
 *
 */
public class Knight extends Piece {

	/**
	 * Constructor for Knight.
	 * 
	 * @param color
	 * @param rank
	 * @param file
	 */
	public Knight(char color, char rank, int file) {
		super(color, rank, file);
		this.symbol = 'N';
	}
	
	/**
	 * Constructor for Knight.
	 * 
	 * @param color
	 * @param i
	 * @param j
	 */
	public Knight(char color, int i, int j) {
		super(color, i, j);
		this.symbol = 'N';
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
