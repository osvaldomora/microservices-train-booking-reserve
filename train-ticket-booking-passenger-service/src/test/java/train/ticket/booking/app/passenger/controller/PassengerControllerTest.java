package train.ticket.booking.app.passenger.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import train.ticket.booking.app.passenger.entity.Passenger;
import train.ticket.booking.app.passenger.service.IPassengerService;

@WebMvcTest(PassengerController.class)
class PassengerControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IPassengerService passengerService;
	
	private Passenger passenger;
	
	@BeforeEach
	void setUp() {
		passenger = new Passenger();
		passenger.setPassengerId(1);
		passenger.setUserId(1);
	}
	
	@Test
	void passengers() throws Exception {
		when(passengerService.getPassengers(Mockito.anyInt())).thenReturn(List.of(passenger));
		
		mockMvc.perform(get("/passengers/1")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is2xxSuccessful());
	}

}
