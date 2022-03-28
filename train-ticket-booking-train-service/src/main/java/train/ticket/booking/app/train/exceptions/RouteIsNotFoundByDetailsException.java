package train.ticket.booking.app.train.exceptions;

public class RouteIsNotFoundByDetailsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RouteIsNotFoundByDetailsException(String message) {
		super(message);
	}

}
