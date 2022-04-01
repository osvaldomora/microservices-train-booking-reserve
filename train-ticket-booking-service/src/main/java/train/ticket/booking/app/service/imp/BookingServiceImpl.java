package train.ticket.booking.app.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import train.ticket.booking.app.dto.BookingReqDto;
import train.ticket.booking.app.dto.UserClient;
import train.ticket.booking.app.dto.UserReq;
import train.ticket.booking.app.dto.client.passenger.PassengerClient;
import train.ticket.booking.app.dto.client.train.TrainDto;
import train.ticket.booking.app.dto.client.train.passanger.BookingReqClientDto;
import train.ticket.booking.app.dto.response.BookingResponseDto;
import train.ticket.booking.app.entity.Booking;
import train.ticket.booking.app.exception.TrainNotFoundException;
import train.ticket.booking.app.repo.client.PassengerClientRest;
import train.ticket.booking.app.repo.client.TrainClientRest;
import train.ticket.booking.app.repo.client.UserClientRest;
import train.ticket.booking.app.repository.BookingRepository;
import train.ticket.booking.app.service.IBookingService;

@Service
@Slf4j
public class BookingServiceImpl implements IBookingService {

	@Autowired(required = false)
	UserClientRest userClientRestFeign;

	@Autowired(required = false)
	TrainClientRest trainClientRestFeign;

	@Autowired(required = false)
	PassengerClientRest passengerClientRest;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	 CircuitBreakerFactory circuitBreakerFactory;

	@Override
	public List<BookingResponseDto> bookTicket(BookingReqDto userReqDto) {

		UserReq user = new UserReq();
		user.setName(userReqDto.getUsername());
		user.setPassword(userReqDto.getPassword());

		/**
		 * A User is created by default if its is not registed yet
		 */
		final UserClient use;
	/*	CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
		use = circuitBreaker.run(() -> userClientRestFeign.login(user), throwable -> getDefaultInfo());
	*/
		use=userClientRestFeign.login(user);
		log.info("user:{}", use);
        
		/*
		 * we mapped the list of the request than contains passanger´s data
		 */
		return userReqDto.getUsersData().stream().map(us -> {

			TrainDto trainDto = null;
			BookingResponseDto bookingRes = null;
			try {//I need to chose the train 
				trainDto = trainClientRestFeign.trains(us.getTrain().getTrainId(), us.getTrain().getSeatNumber());
				log.error("data was not founded");
			} catch (FeignException e) {//break
				log.info("into exception");
				return BookingResponseDto.builder().name(us.getUsername()).success(false)
						.message("The seat number "+ us.getTrain().getSeatNumber()+ " is already occupied").build();
//				throw new TrainNotFoundException("train not was founded");
			}

			Booking book = Booking.builder().trainId(us.getTrain().getTrainId()).userId(use.getUserId()).build();
			book = bookingRepository.save(book);
			//Response Data is created
			bookingRes = BookingResponseDto.builder().name(us.getUsername()).surname(us.getSurname()).trainDto(trainDto)
					.success(true).build();
			//Pasanger is saved
			passengerClientRest.passanger(BookingReqClientDto.builder().bookingId(book.getBookingId())
					.userId(use.getUserId()).seatId(us.getTrain().getSeatNumber()).name(bookingRes.getName())
					.surname(bookingRes.getSurname()).build());
			return bookingRes;
		}).collect(Collectors.toList());

	}

	private UserClient getDefaultInfo() {

		log.info("Testing circuit breaker");

		return userClientRestFeign.save();
	}

	@Override
	public Integer getPort() {

		return userClientRestFeign.port();
	}

	@Override
	public List<BookingResponseDto> bookings(Integer idUser) {
		log.info("idUser" + idUser);
		List<PassengerClient> listP = passengerClientRest.passanger(idUser);
		log.info("PassengerClient" + listP.size());
		return listP.stream().map(passenger -> {
			Booking booking = bookingRepository.findById(passenger.getBookingId())
					.orElseThrow(() -> new TrainNotFoundException("BookingId not was founded"));

			
			TrainDto trainDto = trainClientRestFeign.trains(booking.getTrainId(), passenger.getSeatId());

			return BookingResponseDto.builder().name(passenger.getName()).surname(passenger.getSurname())
					.trainDto(trainDto).build();
		}).collect(Collectors.toList());

	}

}
