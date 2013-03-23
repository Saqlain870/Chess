package cs213.chess.pieces;

import java.util.ArrayList;

import cs213.chess.controls.Board;
import cs213.chess.exceptions.IllegalFileRankException;

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


	/* (non-Javadoc)
	 * @see cs213.chess.pieces.Piece#getValidMoves()
	 */
	@Override
	public ArrayList<String> getValidMoves() {
		ArrayList<String> validMoves = new ArrayList<String>();
		String move;

		int downTwoRanks = this.rank - 2;
		int downRank = this.rank - 1;
		int upRank = this.rank + 1;
		int upTwoRanks = this.rank + 2;

		char downTwoFiles = (char) (((int) this.file) - 2);
		char downFile = (char) (((int) this.file) - 1);
		char upFile = (char) (((int) this.file) + 1);
		char upTwoFiles = (char) (((int) this.file) + 2);

		String[] candidateMoves = {
            downTwoFiles + "" + upRank,
            upTwoFiles + "" + upRank,
            downTwoFiles + "" + downRank,
            upTwoFiles + "" + downRank,
            upFile + "" + downTwoRanks,
            upFile + "" + upTwoRanks,
            downFile + "" + downTwoRanks,
            downFile + "" + upTwoRanks
		};

        for (int i = 0; i < candidateMoves.length; i++) {
            move = candidateMoves[i];
            if (isPossibleMove(move)) {
                validMoves.add(move);
            }
        }

		return validMoves;
	}

	private boolean isPossibleMove(String move) {
		Piece square;
		try {
			square = this.board.getPieceAt(move);
			return (square == null || square.color != this.color);
		} catch (IllegalFileRankException e) {
			return false;
		}

	}

}
