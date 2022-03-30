package train.ticket.booking.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TrainNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(TrainNotFoundException ex) {

		System.out.println("ErrorResponse:" + ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "s0040");
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);

	}

/*	@ExceptionHandler(FeignException.class)
	public ResponseEntity<ErrorResponse> handleException(FeignException ex) {

		System.out.println("ErrorResponse:" + ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "f500");
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);

	}
	*/

	/*
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationErrorResponse> handleExceptionValid(MethodArgumentNotValidException ex) {

		ValidationErrorResponse errorResponse = new ValidationErrorResponse("invalid arguments parameters", Constants.INVALID_ARGS);
		ex.getBindingResult().getFieldErrors().stream().forEach(error->{
			System.out.println("into foreach");
			errorResponse.getInvalidArguments().put(error.getField(), error.getDefaultMessage());
			
		});
		
		errorResponse.setDate(new Date());
		return new ResponseEntity<ValidationErrorResponse>(errorResponse, HttpStatus.OK);

	}
	*/

}
