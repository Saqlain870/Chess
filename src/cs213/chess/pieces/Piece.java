package cs213.chess.pieces;

/**
 * @author bilalq
 *
 */
public abstract class Piece {
	
	protected char color;
	protected char symbol;
	protected int rank;
	protected int file;
	
	protected Piece(char color, int rank, int file) {
		this.color = color;
		this.rank = rank;
		this.file = file;
	}
	
}
