package train.ticket.booking.app.user.service;

import train.ticket.booking.app.user.entity.User;

public interface IUserService {
	
	 User findByNameAndPassword(String name, String pass);
	 
	 User save();


	 
	 
	 

}
