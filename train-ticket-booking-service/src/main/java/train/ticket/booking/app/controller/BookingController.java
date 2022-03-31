package train.ticket.booking.app.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import train.ticket.booking.app.dto.BookingReqDto;
import train.ticket.booking.app.dto.response.BookingResponseDto;
import train.ticket.booking.app.service.IBookingService;


@RestController
@Slf4j
public class BookingController {
	

	@Autowired
	private IBookingService iBookingService;

	@GetMapping("/bookings/port")
	public ResponseEntity<Integer> getPort() {
		return new ResponseEntity<>(iBookingService.getPort(),HttpStatus.OK);
	}


	@PostMapping(value = "/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookingResponseDto>> users(@Valid @RequestBody BookingReqDto userReq) {
		log.info("Entrando en users");
  
		return new ResponseEntity<>(iBookingService.bookTicket(userReq),HttpStatus.OK);
		

	}
	
	@GetMapping(value = "/bookings/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookingResponseDto>> bookings( @PathVariable Integer userId) {
		log.info("Entrando en users");
		
        
		return new ResponseEntity<>(iBookingService.bookings(userId),HttpStatus.OK);
		

	}



}
