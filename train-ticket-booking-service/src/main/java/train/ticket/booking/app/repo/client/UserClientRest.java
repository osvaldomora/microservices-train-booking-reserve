package train.ticket.booking.app.repo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import train.ticket.booking.app.dto.UserDto;
import train.ticket.booking.app.dto.UserReq;


@FeignClient(name = "USER-SERVICE")
public interface UserClientRest {
	
	@PostMapping("/users/v1/users")
	public UserDto login(UserReq user);
	


}
