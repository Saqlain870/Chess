package cs213.chess.pieces;

import cs213.chess.exceptions.IllegalRankFileException;
import cs213.chess.utils.Helper;

/**
 * @author Bilal Quadri
 *
 */
public abstract class Piece {
	
	protected char color;
	protected char symbol;
	protected char rank;
	protected int file;
	
	protected Piece(char color, char rank, int file) {
		this.color = color;
		this.rank = rank;
		this.file = file;
	}
	
	public char getColor() {
		return this.color;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
	public char getRank() {
		return this.rank;
	}
	
	public int getFile() {
		return this.file;
	}
	
	public String getRankFile(){
		return this.rank + "" + this.file;
	}
	
	public int[] getCoords() {
		try {
			return Helper.rankFileToCoords(this.rank, this.file);
		} catch (IllegalRankFileException e) {
			return null;
		}
	}
	
	public String getIdentifier() {
		return this.color + "" + this.symbol;
	}
	
}
