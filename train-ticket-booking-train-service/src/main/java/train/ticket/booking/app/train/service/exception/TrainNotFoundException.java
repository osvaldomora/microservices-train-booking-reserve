package train.ticket.booking.app.train.service.exception;

public class TrainNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TrainNotFoundException(String message) {
		super(message);
	}
}