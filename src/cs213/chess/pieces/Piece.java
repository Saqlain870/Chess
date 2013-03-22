package cs213.chess.pieces;

import java.util.ArrayList;

import cs213.chess.controls.Board;
import cs213.chess.exceptions.IllegalFileRankException;
import cs213.chess.utils.Helper;

/**
 * @author Bilal Quadri
 *
 */
public abstract class Piece {
	
	protected char color;
	protected char symbol;
	protected char file;
	protected int rank;
	protected Board board;
	protected int timesMoved;
	
	protected Piece(char color, char file, int rank, Board board) {
		this.color = color;
		this.file = file;
		this.rank = rank;
		this.board = board;
		this.timesMoved = 0;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getIdentifier();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + color;
		result = prime * result + file;
		result = prime * result + rank;
		result = prime * result + symbol;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (getClass() != obj.getClass()) {
			return false;
		}
		Piece other = (Piece) obj;
		if (color != other.color) {
			return false;
		} else if (file != other.file) {
			return false;
		} else if (rank != other.rank) {
			return false;
		} else if (symbol != other.symbol) {
			return false;
		}
		return true;
	}

	public char getColor() {
		return this.color;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public char getFile() {
		return this.file;
	}
	
	/**
	 * @return The number of times this piece has moved on the board.
	 */
	public int getTimesMoved() {
		return this.timesMoved;
	}
	
	/**
	 * @return Whether or not this piece has ever moved on the board.
	 */
	public boolean hasMoved() {
		return this.timesMoved == 0;
	}
	
	public int incrementTimesMoved() {
		this.timesMoved++;
		return this.timesMoved;
	}
	
	public String getFileRank(){
		return this.file + "" + this.rank;
	}
	
	public int[] getCoords() throws IllegalFileRankException {
		return Helper.filerankToCoords(this.file + "" + this.rank);
	}
	
	public String getIdentifier() {
		return this.color + "" + this.symbol;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public void setFile(char file) {
		this.file = file;
	}
	
	public abstract ArrayList<String> getValidMoves();

	public boolean canMoveTo(String fileRank) {
		return this.getValidMoves().contains(fileRank);
	}

//	public abstract boolean canMoveTo(char rank, int file);
	
//	public abstract boolean canMoveTo(int i, int j);
	
}
