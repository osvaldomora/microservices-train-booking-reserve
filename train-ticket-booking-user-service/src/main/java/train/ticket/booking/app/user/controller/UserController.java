package train.ticket.booking.app.user.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import train.ticket.booking.app.user.dto.request.UserDTO;
import train.ticket.booking.app.user.dto.request.UserReq;
import train.ticket.booking.app.user.entity.User;
import train.ticket.booking.app.user.service.IUserService;


@RestController
public class UserController {
	@Autowired
	private IUserService userService;

	@Value("${server.port}")
	int port;
	
	@GetMapping("/users/port")
	public ResponseEntity<Integer> getPort() {
		return new ResponseEntity<>(port,
				HttpStatus.OK);
	}

	@PostMapping(value = "/users/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> users(@Valid @RequestBody UserReq userReq) {
		
		return new ResponseEntity<>(userService.findByNameAndPassword(userReq.getName(), userReq.getPassword()),
				HttpStatus.OK);

	}

	
	@PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> usersSave(){
		
		return new ResponseEntity<>(userService.save(),HttpStatus.OK);

	}

}
