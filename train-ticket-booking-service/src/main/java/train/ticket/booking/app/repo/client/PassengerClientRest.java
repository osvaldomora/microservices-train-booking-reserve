package train.ticket.booking.app.repo.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import train.ticket.booking.app.dto.client.passenger.PassengerClient;
import train.ticket.booking.app.dto.client.train.passanger.BookingReqClientDto;


@FeignClient(name = "passenger-service")
public interface PassengerClientRest {
	
	@PostMapping("/passengers")
	public void passanger(BookingReqClientDto userReq);
	
	@GetMapping("/passengers/{idUser}")
	public List<PassengerClient> passanger(@PathVariable Integer idUser);
	
	@GetMapping("/users/port")
	public int port();
	


}
