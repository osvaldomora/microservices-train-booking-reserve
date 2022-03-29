package train.ticket.booking.app.passenger.service;

import java.util.List;

import train.ticket.booking.app.passenger.dto.BookingReqDto;
import train.ticket.booking.app.passenger.entity.Passenger;

public interface IPassengerService {
	
	void savePassenger(BookingReqDto userReqDto);
	
	List<Passenger> getPassengers(Integer idPassenger); 

	 Integer getPort();
	


	 
	 
	 

}
