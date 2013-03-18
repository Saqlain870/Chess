package cs213.chess.pieces;

import java.util.ArrayList;

/**
 * @author Bilal Quadri
 *
 */
public class Rook extends Piece {

	/**
	 * Constructor for Rook.
	 * 
	 * @param color
	 * @param rank
	 * @param file
	 */
	public Rook(char color, char rank, int file) {
		super(color, rank, file);
		this.symbol = 'R';
	}
	
	/**
	 * Constructor for Rook.
	 * 
	 * @param color
	 * @param i
	 * @param j
	 */
	public Rook(char color, int i, int j) {
		super(color, i, j);
		this.symbol = 'R';
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
