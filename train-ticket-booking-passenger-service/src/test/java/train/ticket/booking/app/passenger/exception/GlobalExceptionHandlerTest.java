package train.ticket.booking.app.passenger.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;


@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {
	@InjectMocks
	GlobalExceptionHandler globalExceptionHandler;
	@Mock
	BindingResult bindingResult;
	
	@Test
	void handleException() {
		UserNotFoundException ex = new UserNotFoundException("something went wrong");
		ResponseEntity<ErrorResponse> resp=globalExceptionHandler.handleException(ex);
		assertEquals("something went wrong", resp.getBody().getMessage());
	}

}
