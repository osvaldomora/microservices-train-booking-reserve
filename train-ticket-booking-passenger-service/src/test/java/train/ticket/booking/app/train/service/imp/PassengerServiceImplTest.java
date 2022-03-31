package train.ticket.booking.app.train.service.imp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import train.ticket.booking.app.passenger.dto.BookingReqDto;
import train.ticket.booking.app.passenger.entity.Passenger;
import train.ticket.booking.app.passenger.repository.PassengerRepository;
import train.ticket.booking.app.passenger.service.imp.PassengerServiceImpl;

@ExtendWith(MockitoExtension.class)
class PassengerServiceImplTest {
	@Mock
	PassengerRepository passengerRepository;
	@InjectMocks
	PassengerServiceImpl passengerServiceImpl;
	
	Passenger passenger;
	BookingReqDto bookingReqDto;
	
	@BeforeEach
	void setUp() {
		passenger = new Passenger();
		passenger.setPassengerId(1);
		passenger.setBookingId(1);
		passenger.setName("random");
		passenger.setSeatId(1);
		passenger.setSurname("random");
		passenger.setUserId(1);
		
		bookingReqDto = new BookingReqDto();
		bookingReqDto.setBookingId(2);
		bookingReqDto.setName("random");
		bookingReqDto.setSeatId(2);
		bookingReqDto.setSurname("random");
		bookingReqDto.setUserId(2);
		
	}
	

	
	@Test
	void getPassengersTest() {
		
		when(passengerRepository.findByUserId(Mockito.anyInt())).thenReturn(List.of(passenger));
		
		List<Passenger> passengerList = passengerServiceImpl.getPassengers(1);
		
		assertEquals(1, passengerList.get(0).getUserId());

	}
	
	

}
