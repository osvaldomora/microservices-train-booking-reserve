package train.ticket.booking.app.user.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import train.ticket.booking.app.user.dto.request.UserDTO;
import train.ticket.booking.app.user.entity.User;
import train.ticket.booking.app.user.exception.UserNotFoundException;
import train.ticket.booking.app.user.repo.UserRepo;
import train.ticket.booking.app.user.service.IUserService;


@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserRepo userRepo;

	
	@Override
	public UserDTO findByNameAndPassword(String name, String pass) {
		
		return userRepo.findByUsernameAndPassword(name, pass)
				.orElseThrow(() -> new UserNotFoundException("User not found"));

	}


	@Override
	public User save() {
		User user = new User();
		user.setUsername("XXXX");
		user.setEmail("XXXX");
//		user.setUserId(10);
			return userRepo.save(user);
	}


}
