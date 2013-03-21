package cs213.chess.pieces;

import java.util.ArrayList;

import cs213.chess.controls.Board;
import cs213.chess.exceptions.IllegalCoordsException;
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
		int x, y;
		
		try {
			coords = this.getCoords();
			x = coords[1];
			y = coords[0];
			Piece target = this.board.getPieceAt(x, y);
			System.out.println(target);
			System.out.println(x + ", " + y);
			System.out.println(target.getFileRank());
			try {
				System.out.println(Helper.coordsTofileRank(y,  x));
			} catch (IllegalCoordsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Detect vertical moves
//			for (int i = x; i < 8; i++) {
//				if (this.board.getPieceAt(i,  y) == null) {
//					this.validMoves.add(Helper.coordsTofileRank(i, y));
//				}
//			}
//			for (int i = x; i >= 0; i--) {
//				
//			}
		} catch (IllegalFileRankException e) {
			System.out.println("Exception in rook");
		}
		return validMoves;
		
	}

}
