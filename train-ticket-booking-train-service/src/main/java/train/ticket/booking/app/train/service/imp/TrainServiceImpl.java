package train.ticket.booking.app.train.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import train.ticket.booking.app.train.dto.TrainResponseDTO;
import train.ticket.booking.app.train.repo.TrainRepo;
import train.ticket.booking.app.train.service.TrainService;

public class TrainServiceImpl implements TrainService{
	@Autowired
	TrainRepo trainRepo;
	@Override
	public TrainResponseDTO getAllTrainDetails() {
		// TODO Auto-generated method stub
		return null;
	}

}
