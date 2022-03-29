package train.ticket.booking.app.passenger.repo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "USER-SERVICE")
public interface UserClientRest {
	

	
	@GetMapping("/users/port")
	public int port();
	


}
