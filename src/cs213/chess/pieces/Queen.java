package cs213.chess.pieces;

import java.util.ArrayList;

import cs213.chess.controls.Board;
import cs213.chess.exceptions.IllegalFileRankException;

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
		ArrayList<String> validMoves = new ArrayList<String>();

		// BEGIN ROOK LIKE MOVEMENT

		// Detect horizontal moves going right
		for (char f = this.file; f < 'h'; f++) {
			char next = (char) (((int) f) + 1);
			String move = next + "" + this.rank;
			Piece square;
			try {
				square = this.board.getPieceAt(move);
			} catch (IllegalFileRankException e) {
				continue;
			}
			if (square == null) {
				// Square is empty
				validMoves.add(move);
			} else {
				if (this.color != square.getColor()){
					// Square has enemy piece
					validMoves.add(move);
				}
				break;
			}
		}

		// Detect horizontal moves going left
		for (char f = this.file; f > 'a'; f--) {
			char prev = (char) (((int) f) - 1);
			String move = prev + "" + this.rank;
			Piece square;
			try {
				square = this.board.getPieceAt(move);
			} catch (IllegalFileRankException e) {
				continue;
			}
			if (square == null) {
				// Square is empty
				validMoves.add(move);
			} else {
				if (this.color != square.getColor()){
					// Square has enemy piece
					validMoves.add(move);
				}
				break;
			}
		}

		//Detect vertical moves going up
		for (int i = this.rank; i < 8; i++) {
			String move = this.file + "" + (i + 1);
			Piece square;
			try {
				square = this.board.getPieceAt(move);
			} catch (IllegalFileRankException e) {
				continue;
			}
			if (square == null) {
				// Square is empty
				validMoves.add(move);
			} else {
				if (this.color != square.getColor()){
					// Square has enemy piece
					validMoves.add(move);
				}
				break;
			}
		}

		//Detect vertical moves going down
		for (int i = this.rank; i > 1; i--) {
			String move = this.file + "" + (i - 1);
			Piece square;
			try {
				square = this.board.getPieceAt(move);
			} catch (IllegalFileRankException e) {
				continue;
			}
			if (square == null) {
				// Square is empty
				validMoves.add(move);
			} else {
				if (this.color != square.getColor()){
					// Square has enemy piece
					validMoves.add(move);
				}
				break;
			}
		}

		// END ROOK LIKE MOVEMENT

		// BEGIN BISHOP LIKE MOVEMENT

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

		// END BISHOP LIKE MOVEMENT


		return validMoves;
	}

}
