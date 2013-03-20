package cs213.chess.pieces;

import java.util.ArrayList;

import cs213.chess.controls.Board;

/**
 * @author Bilal Quadri
 *
 */
public class Knight extends Piece {

	/**
	 * Constructor for Knight.
	 * 
	 * @param color
	 * @param file
	 * @param rank
	 * @param board
	 */
	public Knight(char color, char file, int rank, Board board) {
		super(color, file, rank, board);
		this.symbol = 'N';
	}
	
	/**
	 * Constructor for Knight.
	 * 
	 * @param color
	 * @param i
	 * @param j
	 * @param board
	 */
	public Knight(char color, int i, int j, Board board) {
		super(color, i, j, board);
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

}
