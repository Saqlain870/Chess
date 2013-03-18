package cs213.chess.controls;

/**
 * 
 * @author Bilal Quadri
 *
 */
public class Game {

	private Board board;
	private char turn;
	
	
	/**
	 * Initialize the game by creating a new board.
	 * 
	 * The board layout is the default chess setup with white set to go first.
	 */
	public Game() {
		this.setBoard(new Board());
		this.turn = 'w';
	}
	

	/**
	 * Gets the board of this game.
	 * 
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	
	/**
	 * Sets the board.
	 * 
	 * @param board the board to set
	 */
	public void setBoard(Board board) {
		this.board = board;
	}
	

	/**
	 * Checks if the board is in either checkmate or stalemate, and determines
	 * if the game is still active.
	 * 
	 * @return Whether or not the game is still ongoing.
	 */
	public boolean isActive() {
		return (! (this.board.isInCheckmate(this.turn) || this.board.isInStalemate(this.turn)) );
	}
}
