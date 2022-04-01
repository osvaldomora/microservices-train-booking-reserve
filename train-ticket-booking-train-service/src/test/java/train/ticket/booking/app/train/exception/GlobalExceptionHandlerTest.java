package train.ticket.booking.app.train.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import train.ticket.booking.app.train.exceptions.ErrorResponse;
import train.ticket.booking.app.train.exceptions.GlobalExceptionHandler;
import train.ticket.booking.app.train.exceptions.RouteIsNotFoundByDetailsException;
import train.ticket.booking.app.train.exceptions.TrainNotFoundByRouteException;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {
	@InjectMocks
	GlobalExceptionHandler globalExceptionHandler;
	
	@Test
	void handleExceptionRouteIsNotFoundTest() {
		RouteIsNotFoundByDetailsException ex = new RouteIsNotFoundByDetailsException("route not found by details");
		ResponseEntity<ErrorResponse> res = globalExceptionHandler.handleException(ex);
		assertEquals("route not found by details", res.getBody().getMessage());
	}
	
	@Test
	void handleExceptionTrainNotFoundByRouteException(){
		TrainNotFoundByRouteException ex = new TrainNotFoundByRouteException("Train not found with route");
		ResponseEntity<ErrorResponse> res = globalExceptionHandler.handleException(ex);
		assertEquals("Train not found with route", res.getBody().getMessage());
	}

}
