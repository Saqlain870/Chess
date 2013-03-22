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
	 * @param file
	 * @param rank
	 * @param board
	 */
	public Queen(char color, char file, int rank, Board board) {
		super(color, file, rank, board);
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

}
