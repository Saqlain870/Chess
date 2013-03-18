package cs213.chess.exceptions;

/**
 * @author Bilal Quadri
 *
 */
public class IllegalCoordsException extends Exception {

	private static final long serialVersionUID = -4858765399746721993L;

	public IllegalCoordsException(String message) {
		super(message);
	}

}