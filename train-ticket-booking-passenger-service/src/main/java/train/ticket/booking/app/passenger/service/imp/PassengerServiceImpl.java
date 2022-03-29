package train.ticket.booking.app.passenger.service.imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import train.ticket.booking.app.passenger.dto.BookingReqDto;
import train.ticket.booking.app.passenger.entity.Passenger;
import train.ticket.booking.app.passenger.repo.client.UserClientRest;
import train.ticket.booking.app.passenger.repository.PassengerRepository;
import train.ticket.booking.app.passenger.service.IPassengerService;


@Service
@Slf4j
public class PassengerServiceImpl implements IPassengerService{

	@Autowired(required=false)
	UserClientRest userClientRestFeign;
	

	@Autowired
	PassengerRepository passengerRepository;


	@Override
	public void savePassenger(BookingReqDto userReqDto) {
		Passenger passsenger=Passenger.builder().BookingId(userReqDto.getBookingId())
				.userId(userReqDto.getUserId())
				.seatId(userReqDto.getSeatId())
				.name(userReqDto.getName()).surname(userReqDto.getSurname()).build();
		passsenger=passengerRepository.save(passsenger);
		log.info("passenger with Id:",passsenger.getPassengerId()+ " was saved");
		
	}
	
	
	@Override
	public List<Passenger> getPassengers(Integer idUser) {
		return passengerRepository.findByUserId(idUser);
	}
	
	@Override
	public Integer getPort() {

		return userClientRestFeign.port();
	}


	

}
