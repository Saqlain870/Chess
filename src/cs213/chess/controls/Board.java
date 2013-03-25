package cs213.chess.controls;

import java.util.ArrayList;

import cs213.chess.exceptions.IllegalColorException;
import cs213.chess.exceptions.IllegalCoordsException;
import cs213.chess.exceptions.IllegalFileRankException;
import cs213.chess.exceptions.IllegalMoveException;
import cs213.chess.pieces.Bishop;
import cs213.chess.pieces.King;
import cs213.chess.pieces.Knight;
import cs213.chess.pieces.Pawn;
import cs213.chess.pieces.Piece;
import cs213.chess.pieces.Queen;
import cs213.chess.pieces.Rook;
import cs213.chess.utils.Helper;

/**
 * @author Bilal Quadri
 *
 */
public class Board {

	private Piece[][] pieces;
	private King whiteKing;
	private King blackKing;
	private Class promotionType;
	
	
	/**
	 * Initializes the board with pieces in their default locations.
	 */
	public Board() {
		this.pieces = new Piece[8][8];
		
		// Place pawns
		for	(int i = 0; i < this.pieces.length; i++) {
			char file = (char) (((int) 'a') + i);
			this.pieces[1][i] = new Pawn('w', file, 2, this);
			this.pieces[6][i] = new Pawn('b', file, 7, this);
		}
		
		// Place kings
		this.whiteKing = new King('w', 'e', 1, this);
		this.blackKing = new King('b', 'e', 8, this);
		this.pieces[0][4] = this.whiteKing;
		this.pieces[7][4] = this.blackKing;
		
		// Place queens
		this.pieces[0][3] = new Queen('w', 'd', 1, this);
		this.pieces[7][3] = new Queen('b', 'd', 8, this);
		
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
	 * @return the promotionType
	 */
	public Class getPromotionType() {
		return promotionType;
	}

	/**
	 * @param promotionType the promotionType to set
	 */
	public void setPromotionType(Class promotionType) {
		this.promotionType = promotionType;
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
	
	
	/**
	 * Gets the piece at a given File and Rank. 
	 * 
	 * @param fileRank The position of the piece you want to retrieve.
	 * @return The piece at this position, or null if it is empty.
	 * @throws IllegalFileRankException 
	 */
	public Piece getPieceAt(String fileRank) throws IllegalFileRankException {
		int[] coords = Helper.filerankToCoords(fileRank);
		return this.pieces[coords[0]][coords[1]];
	}
	
    /**
     * Sets a piece at a given file and rank.
     *
     * @param fileRank The position you want to set.
     * @param piece The piece you want to put at the given position.
     */
	public void setPieceAt(String fileRank, Piece piece) throws IllegalFileRankException {
		int[] coords = Helper.filerankToCoords(fileRank);
		this.pieces[coords[0]][coords[1]] = piece;
	}

	public Piece getPieceAt(int i, int j) {
		return this.pieces[i][j];
	}
	
	public static boolean isInBounds(char file, int rank) {
		return (file >= 'a' && file <= 'h' && rank >= 1 && rank <= 8);
	}
	
	/**
	 * Detects whether or not an empty square is in danger
	 * 
	 * @param fileRank The file and rank of the square you want to check.
	 */
	public boolean emptySquareInDanger(String fileRank, char ownColor) {
		if (ownColor != 'w' || ownColor != 'b') {
			return false;
		}
		Piece temp = new Pawn(ownColor, fileRank.charAt(0), Character.getNumericValue(fileRank.charAt(1)), this);
		return temp.inDanger();
	}

    public boolean testMove(String origin, String dest) {
    	boolean legal = true;
        try {
            Piece temp = getPieceAt(dest);
            Piece moving = getPieceAt(origin);
            
            // Edge case for castling
            if (moving.getClass() == King.class) {
            	int currFile = (int) moving.getFile();
            	int targetFile = (int) dest.charAt(0);
            	int diff = Math.abs(targetFile - currFile);
            	if (diff > 1) {
            		return true;
            	}
            }
            	
            moving.setFileRank(dest);
            setPieceAt(origin, null);
            setPieceAt(dest, moving);
            if (moving.getColor() == 'w') {
            	legal = ! whiteKingInDanger();
            } else {
            	legal = ! blackKingInDanger();
            }
            undoTestMove(origin, dest, temp);
        } catch (IllegalFileRankException e) {
            return false;
        }
        return legal;
    }

    public void undoTestMove(String origin, String dest, Piece temp) {
        try {
            Piece movingBack = getPieceAt(dest);
            movingBack.setFileRank(origin);
            setPieceAt(origin, movingBack);
            setPieceAt(dest, temp);
        } catch (IllegalFileRankException e) {}
    }
    
    public boolean whiteKingInDanger() {
    	return this.whiteKing.inDanger();
    }
    public boolean blackKingInDanger() {
    	return this.blackKing.inDanger();
    }
    
    public void makeMove(char playerColor, String origin, String dest) throws IllegalMoveException, IllegalFileRankException, IllegalColorException {
		Piece moving = getPieceAt(origin);
		if (moving == null) {
			throw new IllegalMoveException("There is no piece at this square");
		}
		
		if (moving.getColor() != playerColor) {
			throw new IllegalColorException("This piece belongs to the other player");
		}
		
		ArrayList<String> legalMoves = moving.getLegalMoves();
		if (legalMoves.contains(dest)) {
			handleCastling(moving, origin, dest);
			setPieceAt(dest, moving);
			setPieceAt(origin, null);
			moving.setFileRank(dest);
			moving.incrementTimesMoved();
			if (pawnDueForPromotion(moving)) {
				Piece upgrade;
				if (getPromotionType() == Rook.class){
					upgrade = new Rook(moving.getColor(), moving.getFile(), moving.getRank(), this);
				} else if (getPromotionType() == Bishop.class){
					upgrade = new Bishop(moving.getColor(), moving.getFile(), moving.getRank(), this);
				} else if (getPromotionType() == Knight.class){
					upgrade = new Knight(moving.getColor(), moving.getFile(), moving.getRank(), this);
				} else {
					upgrade = new Queen(moving.getColor(), moving.getFile(), moving.getRank(), this);
				}
				setPieceAt(dest, upgrade);
			}
		} else {
			throw new IllegalMoveException("This piece cannot move there.");
		}
    }
    
    private boolean pawnDueForPromotion(Piece piece) {
    	if (piece.getClass() != Pawn.class) {
    		return false;
    	}
    	
    	return (
			(piece.getColor() == 'w' && piece.getRank() == 8) || 
			(piece.getColor() =='b' && piece.getRank() == 1)
		);
    		
    }
    
    public void handleCastling(Piece king, String origin, String dest) throws IllegalFileRankException {
    	if (king.getClass() != King.class || king.hasMoved()) {
    		return;
    	}
    	
    	int diff = Math.abs( ((int) origin.charAt(0)) - ((int) dest.charAt(0)) );
    	if (diff > 1) {
	    	char kingFile = dest.charAt(0);
	    	int rank = king.getRank();
	    	String rookOrigin;
	    	String rookDest;
	    	Piece rook;
	    	
	    	if (kingFile == 'g') {
	    		rookOrigin = "h" + rank;
	    		rookDest = "f" + rank;
	    	} else {
	    		rookOrigin = "a" + rank;
	    		rookDest = "d" + rank;
	    	}
	    	
    		rook = getPieceAt(rookOrigin);
	    	setPieceAt(rookOrigin, null);
	    	setPieceAt(rookDest, rook);
	    	rook.setFileRank(rookDest);
    	}
    	
    }
	
}
