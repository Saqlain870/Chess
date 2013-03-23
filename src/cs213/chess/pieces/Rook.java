package cs213.chess.pieces;

import java.util.ArrayList;

import cs213.chess.controls.Board;
import cs213.chess.exceptions.IllegalFileRankException;

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


	/* (non-Javadoc)
	 * @see cs213.chess.pieces.Piece#getValidMoves()
	 */
	@Override
	public ArrayList<String> getValidMoves() {
		ArrayList<String> validMoves = new ArrayList<String>();

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

		return validMoves;
	}

}
