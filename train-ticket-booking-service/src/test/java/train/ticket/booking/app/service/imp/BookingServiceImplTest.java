package train.ticket.booking.app.service.imp;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;

import feign.FeignException;
import train.ticket.booking.app.dto.BookingReqDto;
import train.ticket.booking.app.dto.TrainDataDto;
import train.ticket.booking.app.dto.UserClient;
import train.ticket.booking.app.dto.UserDataDto;
import train.ticket.booking.app.dto.UserReq;
import train.ticket.booking.app.dto.client.passenger.PassengerClient;
import train.ticket.booking.app.dto.client.train.TrainDto;
import train.ticket.booking.app.dto.response.BookingResponseDto;
import train.ticket.booking.app.entity.Booking;
import train.ticket.booking.app.exception.TrainNotFoundException;
import train.ticket.booking.app.repo.client.PassengerClientRest;
import train.ticket.booking.app.repo.client.TrainClientRest;
import train.ticket.booking.app.repo.client.UserClientRest;
import train.ticket.booking.app.repository.BookingRepository;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest(classes = BookingServiceImpl.class)
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
//		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
//@Execution(ExecutionMode.SAME_THREAD)
class BookingServiceImplTest {

//	@Mock
//	 private CircuitBreakerFactory circuitBreakerFactory;



	@Mock
	UserClientRest userClientRestFeign;
	@Mock
	BookingRepository bookingRepository;
	@Mock
	CircuitBreaker circuitBreaker;
	
	@Mock
	PassengerClientRest passengerClientRest;
	
	@Mock
	TrainClientRest trainClientRestFeign;
	


	@InjectMocks
	private BookingServiceImpl bookingServiceImpl;

	@Test
	void bookTicketTest() {

		BookingReqDto userReqDto = BookingReqDto
				.builder().username("osva").password("123567").usersData(List.of(UserDataDto.builder().username("juan")
						.surname("cruz").train(TrainDataDto.builder().seatNumber(1).trainId(1).build()).build()))
				.build();

		UserReq user = new UserReq();
		user.setName(userReqDto.getUsername());
		user.setPassword(userReqDto.getPassword());


		UserClient use = new UserClient();
		use.setUserId(1);
		use.setUsername("osvaldo");
//		Mockito.when(circuitBreakerFactory.create("circuitbreaker")).thenReturn(circuitBreaker);
//		circuitBreakerRegistry.circuitBreaker("circuitbreaker").transitionToClosedState();
//		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
		Mockito.when(userClientRestFeign.login(Mockito.any(UserReq.class))).thenReturn(use);
		Booking book = Booking.builder().trainId(1).userId(1).bookingId(1).build();

		Mockito.when(bookingRepository.save(Mockito.any(Booking.class))).thenReturn(book);

		//		Mockito.when(passengerClientRest.passanger(Mockito.any(BookingReqClientDto.class))).thenReturn(Optional.empty());

		List<BookingResponseDto> response=	bookingServiceImpl.bookTicket(userReqDto);

assertEquals(response.size(), 1);

	}
	
	@Test
	@Disabled
	void bookTicketfail() {

		BookingReqDto userReqDto = BookingReqDto
				.builder().username("osva").password("123567").usersData(List.of(UserDataDto.builder().username("juan")
						.surname("cruz").train(TrainDataDto.builder().seatNumber(1).trainId(1).build()).build()))
				.build();

		UserReq user = new UserReq();
		user.setName(userReqDto.getUsername());
		user.setPassword(userReqDto.getPassword());


		UserClient use = new UserClient();
		use.setUserId(1);
		use.setUsername("osvaldo");
//		Mockito.when(circuitBreakerFactory.create("circuitbreaker")).thenReturn(circuitBreaker);
//		circuitBreakerRegistry.circuitBreaker("circuitbreaker").transitionToClosedState();
//		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
		Mockito.when(userClientRestFeign.login(Mockito.any(UserReq.class))).thenReturn(use);
		Mockito.when(trainClientRestFeign.trains(Mockito.anyInt(), Mockito.any())).thenReturn(null);

		assertThrows(FeignException.class, ()-> bookingServiceImpl.bookTicket(userReqDto));
//		List<BookingResponseDto> response=	bookingServiceImpl.bookTicket(userReqDto);



	}
	
	
	@Test
	void bookings()
	{
		
		List<PassengerClient> listP =List.of(PassengerClient.builder()
				.passengerId(1)
				.userId(1).bookingId(1).seatId(1)
				.name("osvaldo").surname("morales").build());
		Mockito.when(passengerClientRest.passanger(Mockito.anyInt())).thenReturn(listP);
		Mockito.when(trainClientRestFeign.trains(Mockito.anyInt(), Mockito.anyInt())).thenReturn(new TrainDto());

		Mockito.when(bookingRepository.findById(Mockito.anyInt()))
		.thenReturn(Optional.of(Booking.builder().bookingId(1).trainId(1).userId(1).build()));

		List<BookingResponseDto> response=bookingServiceImpl.bookings(1);
		assertAll(
    			()->assertEquals("osvaldo",response.get(0).getName()),
    			()->assertEquals("morales",response.get(0).getSurname())
    			);
	}
	
	
	@Test
	void bookingsFail()
	{
		
		List<PassengerClient> listP =List.of(PassengerClient.builder()
				.passengerId(1)
				.userId(1).bookingId(1).seatId(1)
				.name("osvaldo").surname("morales").build());
		Mockito.when(passengerClientRest.passanger(Mockito.anyInt())).thenReturn(listP);
//		Mockito.when(trainClientRestFeign.trains(Mockito.anyInt(), Mockito.anyInt())).thenReturn(new TrainDto());

		assertThrows(TrainNotFoundException.class, ()-> bookingServiceImpl.bookings(1));

	}

}
