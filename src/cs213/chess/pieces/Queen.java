package cs213.chess.pieces;

import java.util.ArrayList;

/**
 * @author Bilal Quadri
 *
 */
public class Queen extends Piece {

	/**
	 * Constructor for Queen.
	 * 
	 * @param color
	 * @param rank
	 * @param file
	 */
	public Queen(char color, char rank, int file) {
		super(color, rank, file);
		this.symbol = 'Q';
	}
	
	/**
	 * Constructor for Queen.
	 * 
	 * @param color
	 * @param i
	 * @param j
	 */
	public Queen(char color, int i, int j) {
		super(color, i, j);
		this.symbol = 'Q';
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
