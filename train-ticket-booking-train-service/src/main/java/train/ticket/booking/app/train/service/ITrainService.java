package train.ticket.booking.app.train.service;

import train.ticket.booking.app.train.dto.response.TrainDto;

public interface ITrainService {
	
	TrainDto findById(Integer trainId, Integer seatNumber) ;


	 
	 
	 

}
