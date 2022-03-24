package train.ticket.booking.app.user.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import train.ticket.booking.app.user.dto.request.UserReq;
import train.ticket.booking.app.user.service.IUserService;


@RestController
@RequestMapping("/users/v1")
public class UserController {
	@Autowired
	private IUserService userService;



	@PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> users(@Valid @RequestBody UserReq userReq) {
		

		return new ResponseEntity<>(userService.findByNameAndPassword(userReq.getName(), userReq.getPassword()),
				HttpStatus.OK);

	}





}
