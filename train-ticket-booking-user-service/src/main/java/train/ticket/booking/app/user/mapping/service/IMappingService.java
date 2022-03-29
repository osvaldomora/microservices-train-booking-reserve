package train.ticket.booking.app.user.mapping.service;



import train.ticket.booking.app.user.dto.UserDto;
import train.ticket.booking.app.user.entity.User;

public interface IMappingService {
	
	UserDto mappingUSer(User user);
	

}
