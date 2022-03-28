package train.ticket.booking.app.train.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import train.ticket.booking.app.train.dto.response.TrainDto;
import train.ticket.booking.app.train.service.ITrainService;


@RestController
public class TrainController {
	@Autowired
	private ITrainService trainService;

	@GetMapping(value = "/trains/{train-id}/seats/{seat-number}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TrainDto> trains(@Valid @PathVariable("train-id") Integer trainId,@PathVariable("seat-number") Integer seatNumber) {
		System.out.println("Entrando en users");
           
		return new ResponseEntity<>(trainService.findById(trainId, seatNumber),
				HttpStatus.OK);

	}



}
