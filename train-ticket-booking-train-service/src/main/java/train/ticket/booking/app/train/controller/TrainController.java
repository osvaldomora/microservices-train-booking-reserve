package train.ticket.booking.app.train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import train.ticket.booking.app.train.dto.TrainResponseDTO;
import train.ticket.booking.app.train.service.TrainService;


@RestController
public class TrainController {
	@Autowired
	TrainService trainService;
	
	@GetMapping("/trains")
	public ResponseEntity<TrainResponseDTO> getAllStoreDetails(){
		TrainResponseDTO trainResponseDto = trainService.getAllTrainDetails();
		
		return new ResponseEntity<TrainResponseDTO>(trainResponseDto, HttpStatus.OK);
	}
}
