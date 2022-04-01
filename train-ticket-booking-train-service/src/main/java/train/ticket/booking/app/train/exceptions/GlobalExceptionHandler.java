package train.ticket.booking.app.train.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import train.ticket.booking.app.train.constants.Constants;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RouteIsNotFoundByDetailsException.class)
	public ResponseEntity<ErrorResponse> handleException(RouteIsNotFoundByDetailsException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), Constants.ROUTE_NOT_FOUND);
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
		
	}
	
	@ExceptionHandler(TrainNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(TrainNotFoundException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), Constants.TRAIN_ROUTE_NOT_FOUND);
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity<>(errorResponse, HttpStatus.OK);
		
	}
	
	@ExceptionHandler(SeatNotAvaibleException.class)
	public ResponseEntity<ErrorResponse> handleException(SeatNotAvaibleException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), Constants.SEAT_NOT_FOUND);
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
		
	}
	
	@ExceptionHandler(TrainNotFoundByRouteException.class)
	public ResponseEntity<ErrorResponse> handleException(TrainNotFoundByRouteException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), Constants.TRAIN_ROUTE_NOT_FOUND);
		errorResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
		
	}
	
}
