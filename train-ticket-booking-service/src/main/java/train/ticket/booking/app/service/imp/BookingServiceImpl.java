package train.ticket.booking.app.service.imp;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import train.ticket.booking.app.dto.BookingReqDto;
import train.ticket.booking.app.dto.UserClient;
import train.ticket.booking.app.dto.UserReq;
import train.ticket.booking.app.dto.client.TrainDto;
import train.ticket.booking.app.dto.client.passanger.BookingReqClientDto;
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

	@Override
	public List<BookingResponseDto> bookTicket(BookingReqDto userReqDto) {
		
		
		 UserReq user = new UserReq();
		 user.setName(userReqDto.getUsername());
         user.setPassword(userReqDto.getPassword());
         
         final  UserClient  use;
//         try {
         log.info("before call restFeign method");
        	  use= userClientRestFeign.login(user);
        	  log.info("user:{}",use);
//         }
//         catch (FeignException e) {
        	 System.out.println("into feign exception");
//			throw new UserNotFoundException(500,"user not fouded");
//		}
         
		 List<BookingResponseDto> lisBooking = 	 userReqDto.getUsersData().stream().map(us->{

	         TrainDto trainDto=null;
	         BookingResponseDto bookingRes=null;
//	         try {
	          trainDto=  trainClientRestFeign.trains(us.getTrain().getTrainId(), us.getTrain().getSeatNumber());
//	         }catch (FeignException e) {
//	        	 
//	         }
//	        System.out.println("the user Id value is:"+us.getUserId());
	          Booking book= Booking.builder().trainId(us.getTrain().getTrainId()).userId(use.getUserId()).build(); 
	          book=  bookingRepository.save(book);
	          //I need to insert data in tha api pasanger, booking id,username,surname
	          bookingRes =  BookingResponseDto.builder().name(us.getUsername()).surname(us.getSurname()).trainDto(trainDto).build();
	          passengerClientRest.passanger(BookingReqClientDto.builder().bookingId(book.getBookingId())
	        		  .name(bookingRes.getName())
	        		  .surname(bookingRes.getSurname()).build());
	         return bookingRes;
		 }).collect(Collectors.toList());
     
		
		return lisBooking;
	}

	@Override
	public Integer getPort() {
		
		return userClientRestFeign.port();
	}
	






}
