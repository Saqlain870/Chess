package cs213.chess.utils;

import cs213.chess.exceptions.IllegalCoordsException;
import cs213.chess.exceptions.IllegalFileRankException;

/**
 * @author Bilal Quadri
 *
 */
public class Helper {

	public static int[] filerankToCoords(String fileRank) throws IllegalFileRankException {
		if(fileRank.length() < 2) {
			throw new IllegalFileRankException("Invalid rank file.");
		}
		return filerankToCoords(fileRank.charAt(0), Character.getNumericValue(fileRank.charAt(1)));
	}
	
	public static int[] filerankToCoords(char file, int rank) throws IllegalFileRankException {
		int i = file - 'a';
		int j = rank - 1;
		
		if (i < 0 || i > 7 || j < 0 || j > 7) {
			throw new IllegalFileRankException("File: " + i + " ; Rank: " + j);
		}

		int[] coords = {j, i};
		return coords;
	}
	
	public static String coordsToFileRank(int i, int j) throws IllegalCoordsException {
		if (i < 0 || j < 0 || i > 7 || j > 7) {
			throw new IllegalCoordsException("Invalid coordinates passed");
		}
		
		String fileRank = ((char) ('a' + j)) + "" + (i + 1);
		return fileRank;
	}
	
	public static String getSquareRepresentation(int i, int j) throws IllegalCoordsException {
		if (i < 0 || j < 0 || i > 7 || j > 7) {
			throw new IllegalCoordsException("Invalid coordinates passed");
		}
		if (i % 2 == 0 && j % 2 == 0) {
			return "##";
		} else if (i % 2 != 0 && j % 2 != 0) {
			return "##";
		} else {
			return "  ";
		}
	}
	
	public static String getSquareRepresentation(char file, int rank) throws IllegalFileRankException {
		int[] coords = filerankToCoords(file, rank);
		try {
			return getSquareRepresentation(coords[1], coords[0]);
		} catch (IllegalCoordsException e) {
			throw new IllegalFileRankException("Invalid rank file.");
		}
	}
	
	public static String getSquareRepresentation(String fileRank) throws IllegalFileRankException {
		int[] coords = filerankToCoords(fileRank);
		try {
			return getSquareRepresentation(coords[1], coords[0]);
		} catch (IllegalCoordsException e) {
			throw new IllegalFileRankException("Invalid rank file.");
		}
	}
}
