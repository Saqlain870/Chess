package cs213.chess.controls;

import cs213.chess.exceptions.IllegalCoordsException;
import cs213.chess.exceptions.IllegalFileRankException;
import cs213.chess.exceptions.IllegalMoveException;
import cs213.chess.pieces.*;
import cs213.chess.utils.Helper;

/**
 * @author Bilal Quadri
 *
 */
public class Board {

	private Piece[][] pieces;
	private King whiteKing;
	private King blackKing;
	
	
	/**
	 * Initializes the board with pieces in their default locations.
	 */
	public Board() {
		this.pieces = new Piece[8][8];
		
		// Place pawns
		for	(int i = 0; i < this.pieces.length; i++) {
			char file = (char) (((int) 'a') + i);
			this.pieces[1][i] = new Pawn('w', file, 1, this);
			this.pieces[6][i] = new Pawn('b', file, 6, this);
		}
		
		// Place kings
		this.whiteKing = new King('w', 'e', 1, this);
		this.blackKing = new King('b', 'e', 8, this);
		this.pieces[0][4] = this.whiteKing;
		this.pieces[7][4] = this.blackKing;
		
		// Place queens
		this.pieces[0][3] = new Queen('w', 'd', 1, this);
		this.pieces[7][3] = new Queen('b', 'd', 1, this);
		
		// Place bishops
		this.pieces[0][2] = new Bishop('w', 'c', 1, this);
		this.pieces[0][5] = new Bishop('w', 'f', 1, this);
		this.pieces[7][2] = new Bishop('b', 'c', 8, this);
		this.pieces[7][5] = new Bishop('b', 'f', 8, this);
		
		// Place knights
		this.pieces[0][1] = new Knight('w', 'b', 1, this);
		this.pieces[0][6] = new Knight('w', 'g', 1, this);
		this.pieces[7][1] = new Knight('b', 'b', 8, this);
		this.pieces[7][6] = new Knight('b', 'g', 8, this);
		
		// Place rooks
		this.pieces[0][0] = new Rook('w', 'a', 1, this);
		this.pieces[0][7] = new Rook('w', 'h', 1, this);
		this.pieces[7][0] = new Rook('b', 'a', 8, this);
		this.pieces[7][7] = new Rook('b', 'h', 8, this);
	}

	
	/**
	 * @return the pieces
	 */
	public Piece[][] getPieces() {
		return this.pieces;
	}

	
	/**
	 * @param pieces the pieces to set
	 */
	public void setPieces(Piece[][] pieces) {
		this.pieces = pieces;
	}

	
	/**
	 * Turn the board into a string that can be displayed in the command line.
	 */
	@Override
	public String toString() {
		String display = "";
		
		for (int i = pieces.length - 1; i >= 0; i--) {
			for (int j = 0; j < pieces.length; j++) {
				Piece piece = pieces[i][j];
				if (piece == null) {
					try {
						display += Helper.getSquareRepresentation(i, j);
					} catch (IllegalCoordsException e) {
						e.printStackTrace();
						System.out.println("Board is in an invalid state");
						System.exit(1);
					}
				} else {
					display += piece.getIdentifier();
				}
				display += " ";
			}
			display += " " + (i + 1);
			display += "\n";
		}
		display += " a  b  c  d  e  f  g  h\n";
		
		return display;
	}
	
	
	public boolean isInCheckmate(char turn) {
		// TODO
		return false;
	}
	
	public boolean isInStalemate(char turn) {
		// TODO
		return false;
	}
	
	/**
	 * Gets the piece at a given File and Rank. 
	 * 
	 * @param fileRank The position of the piece you want to retrieve.
	 * @return The piece at this position, or null if it is empty.
	 */
	public Piece getPieceAt(String fileRank) {
		int[] coords;
		try {
			coords = Helper.filerankToCoords(fileRank);
		} catch (IllegalFileRankException e) {
			return null;
		}
		return this.pieces[coords[0]][coords[1]];
	}
	
	public void movePiece(String origin, String destination) throws IllegalMoveException {
		// TODO
	}
	
	public Piece getPieceAt(int i, int j) {
		return this.pieces[i][j];
	}
	
}
