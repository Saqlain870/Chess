package cs213.chess.pieces;

import java.util.ArrayList;

import cs213.chess.controls.Board;
import cs213.chess.exceptions.IllegalFileRankException;
import cs213.chess.utils.Helper;

/**
 * @author Bilal Quadri
 *
 */
public class Rook extends Piece {

	/**
	 * Constructor for Rook.
	 * 
	 * @param color
	 * @param file
	 * @param rank
	 * @param board
	 */
	public Rook(char color, char file, int rank, Board board) {
		super(color, file, rank, board);
		this.symbol = 'R';
	}
	
	/**
	 * Constructor for Rook.
	 * 
	 * @param color
	 * @param i
	 * @param j
	 * @param board
	 */
	public Rook(char color, int i, int j, Board board) {
		super(color, i, j, board);
		this.symbol = 'R';
	}

	/* (non-Javadoc)
	 * @see cs213.chess.pieces.Piece#getValidMoves()
	 */
	@Override
	public ArrayList<String> getValidMoves() {
		ArrayList<String> validMoves = new ArrayList<String>();
		int[] coords;
		int i, j;
		
		try {
			coords = this.getCoords();
			i = coords[0];
			j = coords[1];
			System.out.println("FileRank of this piece:" + this.getFileRank());
			System.out.println("The i and j: " + i + ", " + j);
		} catch (IllegalFileRankException e) {
			System.out.println("Exception in rook");
			return validMoves;
		}
		
		return validMoves;
	}

}
