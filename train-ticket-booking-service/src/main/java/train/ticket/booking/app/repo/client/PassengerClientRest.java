package train.ticket.booking.app.repo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import train.ticket.booking.app.dto.client.passanger.BookingReqClientDto;


@FeignClient(name = "passenger-service")
public interface PassengerClientRest {
	
	@PostMapping("/passengers")
	public void passanger(BookingReqClientDto userReq);
	
	@GetMapping("/users/port")
	public int port();
	


}
