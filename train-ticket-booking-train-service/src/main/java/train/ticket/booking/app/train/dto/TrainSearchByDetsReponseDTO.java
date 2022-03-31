package train.ticket.booking.app.train.dto;

import java.util.ArrayList;
import java.util.List;

import train.ticket.booking.app.train.dto.response.TrainSearchDto;

public class TrainSearchByDetsReponseDTO extends ResponseDTO{

	public TrainSearchByDetsReponseDTO(String message, int statusCode) {
		super(message, statusCode);
	}
	private List<TrainSearchDto> trainDetails = new ArrayList<>();
	
	public List<TrainSearchDto> getTrainDetails() {
		return trainDetails;
	}
	public void setTrainDetails(List<TrainSearchDto> trainDetails) {
		this.trainDetails = trainDetails;
	}
}
