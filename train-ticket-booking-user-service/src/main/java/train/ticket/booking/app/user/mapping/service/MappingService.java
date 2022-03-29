package train.ticket.booking.app.user.mapping.service;



import org.springframework.stereotype.Service;

import train.ticket.booking.app.user.dto.UserDto;
import train.ticket.booking.app.user.entity.User;



@Service
public class MappingService implements IMappingService{

	@Override
	public UserDto mappingUSer(User user) {
		//UserDto.builder().userId(user.getUserId()).message("Successful Login").statusCode("200 OK").build();
		UserDto us=new UserDto();
		us.setMessage("Successful Login");
		us.setStatusCode("200 OK");
		us.setUserId(user.getUserId());
		return us;
	}

	

}
