package train.ticket.booking.app.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import train.ticket.booking.app.dto.BookingReqDto;
import train.ticket.booking.app.dto.TrainDataDto;
import train.ticket.booking.app.dto.UserDataDto;
import train.ticket.booking.app.dto.client.train.RouteDto;
import train.ticket.booking.app.dto.client.train.SeatDto;
import train.ticket.booking.app.dto.client.train.TrainDto;
import train.ticket.booking.app.dto.response.BookingResponseDto;
import train.ticket.booking.app.service.IBookingService;

@WebMvcTest(BookingController.class)
class BookingControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IBookingService bookingService;
	
	private ObjectMapper objectMapper;
	private BookingReqDto bookingReq;
	private UserDataDto usersDataDto;
	private TrainDataDto trainDataDto;
	private BookingResponseDto bookingResponse;
	private TrainDto trainDto;
	private RouteDto routeDto;
	private SeatDto seatDto;
	
	@BeforeEach
	void setUp() {
		objectMapper = new ObjectMapper();
		
		trainDataDto = new TrainDataDto();
		trainDataDto.setSeatNumber(1);
		trainDataDto.setTrainId(1);
		
		usersDataDto = new UserDataDto();
		usersDataDto.setUsername("random");
		usersDataDto.setSurname("random");
		usersDataDto.setTrain(trainDataDto);
		
		bookingReq = new BookingReqDto();
		bookingReq.setUsername("random");
		bookingReq.setPassword("123");
		bookingReq.setUsersData(List.of(usersDataDto));
		
		seatDto = new SeatDto();
		seatDto.setNumber("1");
		seatDto.setRow("1");
		
		routeDto = new RouteDto();
		routeDto.setDepartureDate("2022");
		routeDto.setDestination("oaxaca");
		routeDto.setSource("cancun");
		routeDto.setRouteId("1");
		routeDto.setPrice("100");
		
		trainDto = new TrainDto();
		trainDto.setModel("random");
		trainDto.setRoute(routeDto);
		trainDto.setSeat(seatDto);
		trainDto.setTrainId("1");
		
		bookingResponse = new BookingResponseDto();
		bookingResponse.setTrainDto(trainDto);
		bookingResponse.setSuccess(true);
		bookingResponse.setMessage("booking successfull");
		bookingResponse.setName("random");
		bookingResponse.setSurname("random");
	}
	
	@Test
	void testPort() throws Exception {
		mockMvc.perform(get("/bookings/port")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		//assertThat(this.bookingService.getPort()).isEqualTo(8890);
	}
	
	@Test
	void bookTicketTest() throws JsonProcessingException, Exception {
		
		mockMvc.perform(post("/bookings")
				.content(objectMapper.writeValueAsString(bookingReq))
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
			//.andExpect(jsonPath("$.message").value("booking successfull"));
		
	}
	
	@Test
	void bookingsTest() throws Exception {
		when(bookingService.bookings(Mockito.anyInt())).thenReturn(List.of(bookingResponse));
		
		mockMvc.perform(get("/bookings/1")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		
		
	}

}
