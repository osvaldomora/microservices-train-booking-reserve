package train.ticket.booking.app.service;

import train.ticket.booking.app.dto.UserDto;

public interface IUserService {
	
	 UserDto findByNameAndPassword(String name, String pass) ;


	 
	 
	 

}
