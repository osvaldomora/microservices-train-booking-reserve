package train.ticket.booking.app.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import train.ticket.booking.app.dto.UserReq;
import train.ticket.booking.app.service.IUserService;


@RestController
@RequestMapping("/users/v1")

public class BookingController {
	@Autowired
	private IUserService userService;



	@PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> users(@Valid @RequestBody UserReq userReq) {
		System.out.println("Entrando en users");
           
		return new ResponseEntity<>(userService.findByNameAndPassword(userReq.getName(), userReq.getPassword()),
				HttpStatus.OK);

	}



}
