package train.ticket.booking.app.user.service;

import train.ticket.booking.app.user.dto.UserDto;

public interface IUserService {
	
	 UserDto findByNameAndPassword(String name, String pass) ;


	 
	 
	 

}
