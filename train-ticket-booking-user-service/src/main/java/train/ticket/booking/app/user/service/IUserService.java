package train.ticket.booking.app.user.service;

import train.ticket.booking.app.user.dto.request.UserDTO;

public interface IUserService {
	
	UserDTO findByNameAndPassword(String name, String pass);

}
