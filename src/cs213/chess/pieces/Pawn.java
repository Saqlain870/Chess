package cs213.chess.pieces;

import java.util.ArrayList;

import cs213.chess.controls.Board;
import cs213.chess.exceptions.IllegalFileRankException;

/**
 * @author Bilal Quadri
 *
 */
public class Pawn extends Piece {

	/**
	 * Constructor for Pawn.
	 *
	 * @param color
	 * @param file
	 * @param rank
	 * @param board
	 */
	public Pawn(char color, char file, int rank, Board board) {
		super(color, file, rank, board);
		this.symbol = 'p';
	}


	/* (non-Javadoc)
	 * @see cs213.chess.pieces.Piece#getValidMoves()
	 */
	@Override
	public ArrayList<String> getValidMoves() {
		ArrayList<String> validMoves = new ArrayList<String>();
		String move;
		Piece square;

		if (this.color == 'w') {
			// White

			// Moving forward
			move = this.file + "" + (this.rank + 1);
			try {
				square = this.board.getPieceAt(move);
				if (square == null) {
					validMoves.add(move);
					if (! this.hasMoved()) {
						move = this.file + "" + (this.rank + 2);
						square = this.board.getPieceAt(move);
						if (square == null) {
							validMoves.add(move);
						}
					}
				}
			} catch (IllegalFileRankException e) {}
		} else {
            // Black

			// Moving forward
			move = this.file + "" + (this.rank - 1);
			try {
				square = this.board.getPieceAt(move);
				if (square == null) {
					validMoves.add(move);
					if (! this.hasMoved()) {
						move = this.file + "" + (this.rank - 2);
						square = this.board.getPieceAt(move);
						if (square == null) {
							validMoves.add(move);
						}
					}
				}
			} catch (IllegalFileRankException e) {System.out.println("EXCEPTING");}

		}

		return validMoves;
	}

}
