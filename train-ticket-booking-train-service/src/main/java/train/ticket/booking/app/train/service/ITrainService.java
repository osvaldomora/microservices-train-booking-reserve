package train.ticket.booking.app.train.service;

import java.util.List;

import train.ticket.booking.app.train.dto.TrainSearchByDetsReponseDTO;
import train.ticket.booking.app.train.dto.response.TrainDto;

public interface ITrainService {
	
	TrainDto findById(Integer trainId, Integer seatNumber) ;

	TrainSearchByDetsReponseDTO findBySearchDetails(String sourceT, String destinationT, String dateT);

}
