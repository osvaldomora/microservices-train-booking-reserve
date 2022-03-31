package train.ticket.booking.app.user.service;

import train.ticket.booking.app.user.dto.request.UserDTO;
import train.ticket.booking.app.user.entity.User;

public interface IUserService {
	

	UserDTO findByNameAndPassword(String name, String pass);

	User save();

}
