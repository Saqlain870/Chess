package cs213.chess.pieces;

import java.util.ArrayList;

import cs213.chess.controls.Board;

/**
 * @author Bilal Quadri
 *
 */
public class King extends Piece {

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
	}

	/**
	 * Constructor for King.
	 * 
	 * @param color
	 * @param i
	 * @param j
	 * @param board
	 */
	public King(char color, int i, int j, Board board) {
		super(color, i, j, board);
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

	public boolean canKingSideCastle() {
		return false;
	}
	
	public boolean canQueenSideCastle() {
		return false;
	}

}
