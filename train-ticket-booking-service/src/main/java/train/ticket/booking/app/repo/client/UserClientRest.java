package train.ticket.booking.app.repo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import train.ticket.booking.app.dto.UserData;
import train.ticket.booking.app.dto.UserReq;


@FeignClient(name = "USER-SERVICE")
public interface UserClientRest {
	
	@PostMapping("/users")
	public UserData login(UserReq user);
	
	@GetMapping("/users/port")
	public int port();
	


}
