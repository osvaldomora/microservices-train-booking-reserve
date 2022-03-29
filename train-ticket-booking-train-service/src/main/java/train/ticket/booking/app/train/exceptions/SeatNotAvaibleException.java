package train.ticket.booking.app.train.exceptions;

public class SeatNotAvaibleException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SeatNotAvaibleException(String message) {
		super(message);
	}

}
