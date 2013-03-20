package cs213.chess.pieces;

import java.util.ArrayList;

import cs213.chess.controls.Board;

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
	 * @param board
	 */
	public Queen(char color, char rank, int file, Board board) {
		super(color, rank, file, board);
		this.symbol = 'Q';
	}
	
	/**
	 * Constructor for Queen.
	 * 
	 * @param color
	 * @param i
	 * @param j
	 * @param board
	 */
	public Queen(char color, int i, int j, Board board) {
		super(color, i, j, board);
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
