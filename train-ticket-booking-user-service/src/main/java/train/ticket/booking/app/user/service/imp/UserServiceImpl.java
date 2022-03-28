package train.ticket.booking.app.user.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import train.ticket.booking.app.user.dto.UserDto;
import train.ticket.booking.app.user.entity.User;
import train.ticket.booking.app.user.exception.UserNotFoundException;
import train.ticket.booking.app.user.mapping.service.IMappingService;
import train.ticket.booking.app.user.repo.UserRepo;
import train.ticket.booking.app.user.service.IUserService;


@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserRepo userRepo;
	@Autowired
	IMappingService mapping;
	
	@Override
	public User findByNameAndPassword(String name, String pass) {
		
		User user=	userRepo.findByUsernameAndPassword(name, pass)
				.orElseThrow(() -> new UserNotFoundException("User not found"));

        
//		UserDto userDto=mapping.mappingUSer(user);
//		System.out.println(userDto);
		user.setPassword("");
		return user;
	}


}
