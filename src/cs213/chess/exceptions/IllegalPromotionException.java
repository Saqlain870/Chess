package cs213.chess.exceptions;

/**
 * @author bilalq
 *
 */
public class IllegalPromotionException extends Exception {

	private static final long serialVersionUID = 707053915317652726L;

	public IllegalPromotionException(String message) {
		super(message);
	}
	
}
