package train.ticket.booking.app.train.exceptions;

public class TrainNotFoundByRouteException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TrainNotFoundByRouteException(String message) {
		super(message);
	}
}
