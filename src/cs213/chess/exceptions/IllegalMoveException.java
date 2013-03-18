package cs213.chess.exceptions;

/**
 * @author Bilal Quadri
 *
 */
public class IllegalMoveException extends Exception {
	
	private static final long serialVersionUID = 5565825211012435042L;

	public IllegalMoveException(String message) {
		super(message);
	}

}
