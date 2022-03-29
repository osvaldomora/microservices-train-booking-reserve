package train.ticket.booking.app.passenger.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
	
	


	public ErrorResponse(String message, String statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}

	private static final long serialVersionUID = 1L;

	private  String message;
	
	private  String statusCode;
	private LocalDateTime dateTime;
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
