package train.ticket.booking.app.passenger.controller;


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
import train.ticket.booking.app.passenger.dto.BookingReqDto;
import train.ticket.booking.app.passenger.entity.Passenger;
import train.ticket.booking.app.passenger.service.IPassengerService;


@RestController
public class PassengerController {
	

	@Autowired
	private IPassengerService iPassengerService;

	@GetMapping("/passengers/port")
	public ResponseEntity<Integer> getPort() {
		return new ResponseEntity<>(iPassengerService.getPort(),HttpStatus.OK);
	}


	@PostMapping(value = "/passengers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> passengers(@Valid @RequestBody BookingReqDto userReq) {

		iPassengerService.savePassenger(userReq);
        
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/passengers/{idUser}")
	public ResponseEntity<List<Passenger>> passengers(@PathVariable Integer idUser) {
		return new ResponseEntity<>(iPassengerService.getPassengers(idUser),HttpStatus.OK);
	}



}
