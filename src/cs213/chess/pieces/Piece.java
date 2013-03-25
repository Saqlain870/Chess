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
		return this.timesMoved > 0;
	}
	
	public int incrementTimesMoved() {
		this.timesMoved++;
		return this.timesMoved;
	}
	
	public String getFileRank(){
		return this.file + "" + this.rank;
	}

    public void setFileRank(String fileRank) {
        this.file = fileRank.charAt(0);
        this.rank = Character.getNumericValue(fileRank.charAt(1));
    }
	
	public int[] getCoords() throws IllegalFileRankException {
		return Helper.filerankToCoords(this.file + "" + this.rank);
	}
	
	/**
	 * Gets the identifier for this piece. Represented as colorSymbol (e.g., wB means white bishop).
	 * @return The identifier of this piece.
	 */
	public String getIdentifier() {
		return this.color + "" + this.symbol;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public void setFile(char file) {
		this.file = file;
	}
	
	/**
	 * Gets all valid moves for a piece. Does not check if the king would be in danger afterwards.
	 * 
	 * @return An ArrayList of fileRanks.
	 */
	public abstract ArrayList<String> getValidMoves();

	public ArrayList<String> getLegalMoves() {
		ArrayList<String> candidateMoves = getValidMoves();
		ArrayList<String> legalMoves = new ArrayList<String>();
		
		for (String move : candidateMoves) {
			if (this.board.testMove(this.getFileRank(), move)) {
				legalMoves.add(move);
			}
		}
		return legalMoves;
	}
	
	/**
	 * Checks if this piece has any legal moves available right now.
	 * 
	 * @return boolean
	 */
	public boolean canMove() {
		ArrayList<String> candidateMoves = getValidMoves();
		
		for (String move : candidateMoves) {
			if (this.board.testMove(this.getFileRank(), move)) {
				return true;
			}
		}
		return false;
	}

    public boolean inDanger() {
    	
    	if (inDangerFromEnemyKnights()) {
    		return true;
    	}
		
    	if (inDangerFromImmediateDiagonals()) {
    		return true;
    	}
		
		if (inDangerFromEnemyKing()) {
			return true;
		}
		
		if (inDangerFromDiagonals()) {
			return true;
		}
		
		if (inDangerFromStraights()) {
			return true;
		}
	    	
    	return false;
    }
    
    public boolean inDangerFromStraights() {
		// Detect horizontal moves going right
		for (char f = this.file; f < 'h'; f++) {
			char next = (char) (((int) f) + 1);
			String move = next + "" + this.rank;
			Piece square;
			try {
				square = this.board.getPieceAt(move);
				if (square != null) {
					if (this.color == square.color) {
						break;
					} else {
						return true;
					}
				}
			} catch (IllegalFileRankException e) {}
		}

		// Detect horizontal moves going left
		for (char f = this.file; f > 'a'; f--) {
			char prev = (char) (((int) f) - 1);
			String move = prev + "" + this.rank;
			Piece square;
			try {
				square = this.board.getPieceAt(move);
				if (square != null) {
					if (this.color == square.color) {
						break;
					} else {
						return true;
					}
				}
			} catch (IllegalFileRankException e) {}
		}

		//Detect vertical moves going up
		for (int i = this.rank; i < 8; i++) {
			String move = this.file + "" + (i + 1);
			Piece square;
			try {
				square = this.board.getPieceAt(move);
				if (square != null) {
					if (this.color == square.color) {
						break;
					} else {
						return true;
					}
				}
			} catch (IllegalFileRankException e) {}
		}

		//Detect vertical moves going down
		for (int i = this.rank; i > 1; i--) {
			String move = this.file + "" + (i - 1);
			Piece square;
			try {
				square = this.board.getPieceAt(move);
				square = this.board.getPieceAt(move);
				if (square != null) {
					if (this.color == square.color) {
						break;
					} else {
						return true;
					}
				}
			} catch (IllegalFileRankException e) {}
		}
		
    	return false;
    }
    
    public boolean inDangerFromDiagonals() {
		boolean upUp = true;
		boolean upDown = true;
		boolean downUp = true;
		boolean downDown = true;
		for (int i = 1; this.rank + i < 9; i++) {
			char downFile = (char) (((int) this.file) - i);
			char upFile = (char) (((int) this.file) + i);
			int downRank = this.rank - i;
			int upRank = this.rank + i;
			Piece square;
			String move;

			if (upUp) {
				move = upFile + "" + upRank;
				try {
					square = this.board.getPieceAt(move);
					if (square != null && square.color != this.color && (square.getClass() == Bishop.class || square.getClass() == Queen.class)) {
						return true;
					}
					if (square != null) {
						upUp = false;
					}
				} catch (IllegalFileRankException e) {
					upUp = false;
				}
			}
			if (upDown) {
				move = upFile + "" + downRank;
				try {
					square = this.board.getPieceAt(move);
					if (square != null && square.color != this.color && (square.getClass() == Bishop.class || square.getClass() == Queen.class)) {
						return true;
					}
					if (square != null) {
						upDown = false;
					}
				} catch (IllegalFileRankException e) {
					upDown = false;
				}
			}
			if (downUp) {
				move = downFile + "" + upRank;
				try {
					square = this.board.getPieceAt(move);
					if (square != null && square.color != this.color && (square.getClass() == Bishop.class || square.getClass() == Queen.class)) {
						return true;
					}
					if (square != null) {
						downUp = false;
					}
				} catch (IllegalFileRankException e) {
					downUp = false;
				}
			}

			if (downDown) {
				move = downFile + "" + downRank;
				try {
					square = this.board.getPieceAt(move);
					if (square != null && square.color != this.color && (square.getClass() == Bishop.class || square.getClass() == Queen.class)) {
						return true;
					}
					if (square != null) {
						downDown = false;
					}
				} catch (IllegalFileRankException e) {
					downDown = false;
				}
			}
		}
    	return false;
    }
	
	public boolean inDangerFromEnemyKnights() {
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
			try {
				Piece threat = this.board.getPieceAt(candidateMoves[i]);
				if (threat != null && threat.getClass() == Knight.class && threat.color != this.color) {
					return true;
				}
			} catch (IllegalFileRankException e) {
				continue;
			}
		}
		
		return false;
	}
	
	public boolean inDangerFromImmediateDiagonals() {
		String leftDiag, rightDiag;
		Piece leftThreat, rightThreat;
		if (this.isWhite()) {
			leftDiag = this.prevFile() + "" + this.nextRank();
			rightDiag = this.nextFile() + "" + this.nextRank();
		} else {
			leftDiag = this.prevFile() + "" + this.prevRank();
			rightDiag = this.nextFile() + "" + this.prevRank();
		}
		
		// Check left diagonal
		try {
			leftThreat = this.board.getPieceAt(leftDiag);
			if (leftThreat != null 
				&& leftThreat.color != this.color
				&& (
					leftThreat.getClass() == King.class
					|| leftThreat.getClass() == Bishop.class
					|| leftThreat.getClass() == Pawn.class
					|| leftThreat.getClass() == Queen.class
					)
				) {
				return true;
			}
		} catch (IllegalFileRankException e) {}
		
		// Check right diagonal
		try {
			rightThreat = this.board.getPieceAt(rightDiag);
			if (rightThreat != null 
				&& rightThreat.color != this.color
				&& (rightThreat.getClass() == King.class
					|| rightThreat.getClass() == Bishop.class
					|| rightThreat.getClass() == Pawn.class
					|| rightThreat.getClass() == Queen.class
				)) {
				return true;
			}
		} catch (IllegalFileRankException e) {}
		
		return false;
	}
    
    public boolean inDangerFromEnemyKing() {
		Piece possibleKing = null;
		for (char i = this.prevFile(); i <= this.nextFile(); i = (char) (((int) i) + 1)) {
			for (int j = this.prevRank(); j <= this.nextRank(); j++) {
				if (i == this.file && j == this.rank) {
					continue;
				}
				try {
					String square = i + "" + j;
					possibleKing = this.board.getPieceAt(square);
					if (possibleKing != null && possibleKing.color != this.color && possibleKing.getClass() == King.class) {
						return true;
					}
				} catch (IllegalFileRankException e) {
					continue;
				}
			}
		}
		return false;
    }
    
    public boolean isWhite() {
    	return this.color == 'w';
    }
    
    public boolean isBlack() {
    	return this.color == 'b';
    }
    
    public char prevFile() {
    	char prev = (char) (((int) this.file) - 1);
    	return prev;
    }
    
    public char nextFile() {
    	char next = (char) (((int) this.file) + 1);
    	return next;
    }
    
    public int prevRank() {
    	return this.rank - 1;
    }
    
    public int nextRank() {
    	return this.rank + 1;
    }
    
}
