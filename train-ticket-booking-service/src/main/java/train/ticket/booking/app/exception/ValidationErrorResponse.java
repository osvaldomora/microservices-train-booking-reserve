package train.ticket.booking.app.exception;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ValidationErrorResponse extends ErrorResponse{
	
	Map<String,String> invalidArguments = new HashMap<String, String>();
	
	private Date date; ;

	public ValidationErrorResponse(String message, String statusCode) {
		super(message, statusCode);
		// TODO Auto-generated constructor stub
	}

	public Map<String, String> getInvalidArguments() {
		return invalidArguments;
	}

	public void setInvalidArguments(Map<String, String> invalidArguments) {
		this.invalidArguments = invalidArguments;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	

}
