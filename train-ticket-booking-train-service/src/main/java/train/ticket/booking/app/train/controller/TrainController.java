package train.ticket.booking.app.train.controller;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import train.ticket.booking.app.train.dto.TrainDetails;
import train.ticket.booking.app.train.dto.TrainSearchByDetsReponseDTO;
import train.ticket.booking.app.train.dto.response.TrainDto;
import train.ticket.booking.app.train.entity.Train;
import train.ticket.booking.app.train.service.ITrainService;


@RestController
@Validated
public class TrainController {
	@Autowired
	private ITrainService trainService;

	@GetMapping(value = "/trains/{train-id}/seats/{seat-number}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TrainDto> trains(@Valid @PathVariable("train-id") Integer trainId,
			@PathVariable("seat-number") Integer seatNumber) {
           
		return new ResponseEntity<>(trainService.findById(trainId, seatNumber),
				HttpStatus.OK);
	}

	//source, destination, date
	@GetMapping(value = "/trains/search/{source}/{destination}/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TrainSearchByDetsReponseDTO> searchTrainBySourceDestination(@Valid @PathVariable("source") @NotEmpty String sourceT, 
			@PathVariable("destination") String destinationT,
			@PathVariable("date") String dateT){
		
		TrainSearchByDetsReponseDTO trainSearchDto = trainService.findBySearchDetails(sourceT, destinationT, dateT);
		
		
		return new ResponseEntity<>(trainSearchDto, HttpStatus.OK);
	}
	
}
