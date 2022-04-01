package train.ticket.booking.app.passenger.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.fasterxml.jackson.databind.ObjectMapper;

import train.ticket.booking.app.passenger.dto.BookingReqDto;
import train.ticket.booking.app.passenger.entity.Passenger;
import train.ticket.booking.app.passenger.service.IPassengerService;

@WebMvcTest(PassengerController.class)
class PassengerControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IPassengerService passengerService;
	
	private BookingReqDto bookingReq;
	private ObjectMapper objectMapper;
	private Passenger passenger;
	
	@BeforeEach
	void setUp() {
		objectMapper = new ObjectMapper();
		passenger = new Passenger();
		passenger.setPassengerId(1);
		passenger.setUserId(1);
		
		bookingReq = new BookingReqDto();
		bookingReq.setBookingId(1);
		bookingReq.setName("random");
		bookingReq.setSeatId(1);
		bookingReq.setSurname("random");
		bookingReq.setUserId(1);
	}
	
	@Test
	void savePassenger() throws Exception{
		
		mockMvc.perform(post("/passengers")
			.content(objectMapper.writeValueAsString(bookingReq))
			.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNoContent());
		
	}
	
	@Test
	void passengers() throws Exception {
		when(passengerService.getPassengers(Mockito.anyInt())).thenReturn(List.of(passenger));
		
		mockMvc.perform(get("/passengers/1")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is2xxSuccessful());
	}
	
	@Test
	void testPort() throws Exception {
		mockMvc.perform(get("/passengers/port")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}

}
