package train.ticket.booking.app.user.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import train.ticket.booking.app.user.entity.User;
import train.ticket.booking.app.user.exception.UserNotFoundException;
import train.ticket.booking.app.user.repo.UserRepo;
import train.ticket.booking.app.user.service.IUserService;


@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserRepo userRepo;

	
	@Override
	public User findByNameAndPassword(String name, String pass) {	
		User user=	userRepo.findByUsernameAndPassword(name, pass)
				.orElseThrow(() -> new UserNotFoundException("User not found"));
		

		user.setPassword("");
		return user;
	}


	@Override
	public User save() {
		User user = new User();
		user.setUsername("XXXX");
		user.setEmail("XXXX");
			return userRepo.save(user);
	}


}
