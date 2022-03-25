package train.ticket.booking.app.user.dto;



//@Getter
//@Setter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class UserReqDto {
    
	
	private Integer userId;
	private String message;
	private String statusCode;
	
	
	
	public UserReqDto() {
		super();
		
	}

	public UserReqDto(Integer userId, String message, String statusCode) {
		super();
		this.userId = userId;
		this.message = message;
		this.statusCode = statusCode;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	

}


