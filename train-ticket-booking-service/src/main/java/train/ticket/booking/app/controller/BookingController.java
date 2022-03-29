package train.ticket.booking.app.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import train.ticket.booking.app.dto.BookingReqDto;
import train.ticket.booking.app.service.IBookingService;


@RestController
public class BookingController {
	
	
	

	
	@Autowired
	private IBookingService iBookingService;

	@GetMapping("/bookings/port")
	public ResponseEntity<?> getPort() {
		return new ResponseEntity<>(iBookingService.getPort(),HttpStatus.OK);
	}


	@PostMapping(value = "/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> users(@Valid @RequestBody BookingReqDto userReq) {
		System.out.println("Entrando en users");
		

		return new ResponseEntity<>(iBookingService.bookTicket(userReq),HttpStatus.OK);
		
	

	}



}
