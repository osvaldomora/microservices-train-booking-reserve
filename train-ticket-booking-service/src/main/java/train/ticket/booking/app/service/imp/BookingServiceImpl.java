package train.ticket.booking.app.service.imp;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import train.ticket.booking.app.dto.BookingReqDto;
import train.ticket.booking.app.dto.UserData;
import train.ticket.booking.app.dto.UserReq;
import train.ticket.booking.app.dto.client.TrainDto;
import train.ticket.booking.app.dto.response.BookingResponseDto;
import train.ticket.booking.app.entity.Booking;
import train.ticket.booking.app.repo.client.TrainClientRest;
import train.ticket.booking.app.repo.client.UserClientRest;
import train.ticket.booking.app.repository.BookingRepository;
import train.ticket.booking.app.service.IBookingService;


@Service
public class BookingServiceImpl implements IBookingService{

	@Autowired(required=false)
	UserClientRest userClientRestFeign;
	
	@Autowired(required=false)
	TrainClientRest trainClientRestFeign;
	
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public List<BookingResponseDto> bookTicket(BookingReqDto userReqDto) {
		
		
		 UserReq user = new UserReq();
		 List<BookingResponseDto> lisBooking = 	 userReqDto.getUsersData().stream().map(us->{
		     user.setName(us.getUsername());
	         user.setPassword(us.getPassword());
	         UserData use=null;
//	         try {
	        	  use= userClientRestFeign.login(user);
//	         }
//	         catch (FeignException e) {
	        	 System.out.println("into feign exception");
//				throw new UserNotFoundException(500,"user not fouded");
//			}
	         TrainDto trainDto=null;
	         BookingResponseDto bookingRes=null;
//	         try {
	          trainDto=  trainClientRestFeign.trains(us.getTrainId(), us.getSeatNumber());
//	         }catch (FeignException e) {
//	        	 
//	         }
	        System.out.println("the user Id value is:"+us.getUserId());
	          Booking book= Booking.builder().trainId(us.getTrainId()).userId(us.getUserId()).build(); 
	          bookingRepository.save(book);
	          bookingRes =  BookingResponseDto.builder().name(use.getUsername()).surname(use.getPassword()).trainDto(trainDto).build();
	         
	         return bookingRes;
		 }).collect(Collectors.toList());
     
		
		return lisBooking;
	}

	@Override
	public Integer getPort() {
		
		return userClientRestFeign.port();
	}
	






}
