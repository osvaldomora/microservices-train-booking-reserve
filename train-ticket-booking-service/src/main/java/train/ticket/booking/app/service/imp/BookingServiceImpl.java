package train.ticket.booking.app.service.imp;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import train.ticket.booking.app.dto.BookingReqDto;
import train.ticket.booking.app.dto.UserClient;
import train.ticket.booking.app.dto.UserReq;
import train.ticket.booking.app.dto.client.passenger.PassengerClient;
import train.ticket.booking.app.dto.client.train.TrainDto;
import train.ticket.booking.app.dto.client.train.passanger.BookingReqClientDto;
import train.ticket.booking.app.dto.response.BookingResponseDto;
import train.ticket.booking.app.entity.Booking;
import train.ticket.booking.app.repo.client.PassengerClientRest;
import train.ticket.booking.app.repo.client.TrainClientRest;
import train.ticket.booking.app.repo.client.UserClientRest;
import train.ticket.booking.app.repository.BookingRepository;
import train.ticket.booking.app.service.IBookingService;


@Service
@Slf4j
public class BookingServiceImpl implements IBookingService{

	@Autowired(required=false)
	UserClientRest userClientRestFeign;
	
	@Autowired(required=false)
	TrainClientRest trainClientRestFeign;
	
	@Autowired(required=false)
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
         
         final  UserClient  use;
         CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");

//         try {
         log.info("before call restFeign method");
//        	  use= userClientRestFeign.login(user);
        	  use=	 circuitBreaker.run(() -> userClientRestFeign.login(user), throwable -> getDefaultInfo());

        	  log.info("user:{}",use);
//         }
//         catch (FeignException e) {
        	 System.out.println("into feign exception");
//			throw new UserNotFoundException(500,"user not fouded");
//		}
         
		 return userReqDto.getUsersData().stream().map(us->{

	         TrainDto trainDto=null;
	         BookingResponseDto bookingRes=null;
//	         CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
//	         try {
		          trainDto=  trainClientRestFeign.trains(us.getTrain().getTrainId(), us.getTrain().getSeatNumber());
		          log.info("despues de obtener cliente feiggnr");
//		         }catch (FeignException e) {
//		        	throw new TrainNotFoundException("dddd") ;
//		          trainDto=	 circuitBreaker.run(() -> trainClientRestFeign.trains(us.getTrain().getTrainId(), us.getTrain().getSeatNumber()), throwable -> getDefaultInfo());
//		         }
//	        System.out.println("the user Id value is:"+us.getUserId());
	          Booking book= Booking.builder().trainId(us.getTrain().getTrainId()).userId(use.getUserId()).build(); 
	          book=  bookingRepository.save(book);
	          //I need to insert data in tha api pasanger, booking id,username,surname,seatId
	          bookingRes =  BookingResponseDto.builder().name(us.getUsername())
	        		  .surname(us.getSurname()).trainDto(trainDto).build();
	          passengerClientRest.passanger(BookingReqClientDto.builder().bookingId(book.getBookingId())
	        		  .userId(use.getUserId())
	        		  .seatId(us.getTrain().getSeatNumber())
	        		  .name(bookingRes.getName())
	        		  .surname(bookingRes.getSurname()).build());
	         return bookingRes;
		 }).collect(Collectors.toList());
     
	}

	private UserClient getDefaultInfo() {
		
		log.info("Testing circuit breaker");
		UserClient userDefault=new UserClient();
		userDefault.setUsername("xxxx");
		userDefault.setUserId(0);
		userDefault.setEmail("xxxx");
		return new UserClient();
	}

	@Override
	public Integer getPort() {
		
		return userClientRestFeign.port();
	}

	@Override
	public List<BookingResponseDto> bookings(Integer idUser) {
		log.info("idUser"+idUser);
		List<PassengerClient> listP=passengerClientRest.passanger(idUser);
		log.info("PassengerClient"+listP.size());
		
		return listP.stream().map(passenger->{ 
			Booking booking=bookingRepository.findById(passenger.getBookingId()).orElseThrow(()-> new RuntimeException());
			
			log.info("brrajinG");
			TrainDto trainDto=  trainClientRestFeign.trains(booking.getTrainId(), passenger.getSeatId());
			return BookingResponseDto.builder().name(passenger.getName()).surname(passenger.getSurname()).trainDto(trainDto).build();
			
		}).collect(Collectors.toList());
		
	}
	






}
