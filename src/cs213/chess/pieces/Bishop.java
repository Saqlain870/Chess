package cs213.chess.pieces;

import java.util.ArrayList;

import cs213.chess.controls.Board;
import cs213.chess.exceptions.IllegalFileRankException;

/**
 * @author Bilal Quadri
 *
 */
public class Bishop extends Piece {

	/**
	 * Constructor for Bishop.
	 * 
	 * @param color
	 * @param file
	 * @param rank
	 * @param board
	 */
	public Bishop(char color, char file, int rank, Board board) {
		super(color, file, rank, board);
		this.symbol = 'B';
	}
	

	/* (non-Javadoc)
	 * @see cs213.chess.pieces.Piece#getValidMoves()
	 */
	@Override
	public ArrayList<String> getValidMoves() {
		ArrayList<String> validMoves = new ArrayList<String>();
		
		// Flags to determine if valid moves can exist in that direction
		boolean upUp = true;
		boolean upDown = true;
		boolean downUp = true;
		boolean downDown = true;
		
		for (int i = 1; this.rank + i < 9; i++) {
			char downFile = (char) (((int) this.file) - i);
			char upFile = (char) (((int) this.file) + i);
			int downRank = this.rank - i;
			int upRank = this.rank + i;
			Piece square;
			String move;
			
			if (upUp) {
				move = upFile + "" + upRank;
				try {
					square = this.board.getPieceAt(move);
					if (square == null) {
						validMoves.add(move);
					} else {
						if (square.color != this.color) {
							validMoves.add(move);
						}
						upUp = false;
					}
				} catch (IllegalFileRankException e) {
					upUp = false;
				}
			}
			
			if (upDown) {
				move = upFile + "" + downRank;
				try {
					square = this.board.getPieceAt(move);
					if (square == null) {
						validMoves.add(move);
					} else {
						if (square.color != this.color) {
							validMoves.add(move);
						}
						upDown = false;
					}
				} catch (IllegalFileRankException e) {
					upDown = false;
				}
			}
			
			if (downUp) {
				move = downFile + "" + upRank;
				try {
					square = this.board.getPieceAt(move);
					if (square == null) {
						validMoves.add(move);
					} else {
						if (square.color != this.color) {
							validMoves.add(move);
						}
						downUp = false;
					}
				} catch (IllegalFileRankException e) {
					downUp = false;
				}
			}
			
			if (downDown) {
				move = downFile + "" + downRank;
				try {
					square = this.board.getPieceAt(move);
					if (square == null) {
						validMoves.add(move);
					} else {
						if (square.color != this.color) {
							validMoves.add(move);
						}
						downDown = false;
					}
				} catch (IllegalFileRankException e) {
					downDown = false;
				}
			}
		}
		
		return validMoves;
	}

}
