package train.ticket.booking.app.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import train.ticket.booking.app.dto.UserDto;
import train.ticket.booking.app.dto.UserReq;
import train.ticket.booking.app.repo.client.UserClientRest;
import train.ticket.booking.app.service.IUserService;


@Service
public class UserServiceImpl implements IUserService{

	@Autowired//(required=false)
	UserClientRest userClientRestFeign;

	
	@Override
	public UserDto findByNameAndPassword(String name, String pass) {
		
         UserReq user = new UserReq();
         user.setName(name);
         user.setPassword(pass);
		return userClientRestFeign.login(user);
	}


}
