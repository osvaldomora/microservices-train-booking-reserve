package train.ticket.booking.app.train.service;

import train.ticket.booking.app.train.dto.UserDto;

public interface IUserService {
	
	 UserDto findByNameAndPassword(String name, String pass) ;


	 
	 
	 

}
