package cs213.chess.pieces;

import java.util.ArrayList;

import cs213.chess.exceptions.IllegalCoordsException;
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
	
	protected Piece(char color, int i, int j) {
		this.color = color;
		
		try {
			String rankFile = Helper.coordsToRankFile(i, j);
			this.rank = rankFile.charAt(0);
			System.out.println("RankFile:" + rankFile);
			this.file = rankFile.charAt(1);
		} catch (IllegalCoordsException e) {
			e.printStackTrace();
		}
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
	
	public void setRank(char rank) {
		this.rank = rank;
	}
	
	public void setFile(int file) {
		this.file = file;
	}
	
	public abstract ArrayList<String> getValidMoves();

	public abstract boolean canMoveTo(String rankFile);

//	public abstract boolean canMoveTo(char rank, int file);
	
//	public abstract boolean canMoveTo(int i, int j);
	
}
