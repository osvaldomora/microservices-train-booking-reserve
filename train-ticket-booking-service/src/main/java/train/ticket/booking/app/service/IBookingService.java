package train.ticket.booking.app.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import train.ticket.booking.app.dto.BookingReqDto;
import train.ticket.booking.app.dto.response.BookingResponseDto;

public interface IBookingService {
	
	List<BookingResponseDto> bookTicket(BookingReqDto userReqDto);
	
	List<BookingResponseDto> bookings(Integer idUser);

	
	 Integer getPort();
	


	 
	 
	 

}
