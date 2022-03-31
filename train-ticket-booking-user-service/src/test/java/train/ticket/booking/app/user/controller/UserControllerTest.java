package train.ticket.booking.app.user.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import train.ticket.booking.app.user.dto.request.UserDTO;
import train.ticket.booking.app.user.dto.request.UserReq;
import train.ticket.booking.app.user.entity.User;
import train.ticket.booking.app.user.service.IUserService;

@WebMvcTest(UserController.class)
class UserControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private IUserService userService;
	
	private UserReq userReq;
	private UserDTO userdto;
	ObjectMapper objectMapper;
	private User user;
	
	@BeforeEach
	void setUp() {
		userdto = new UserDTO("random", "random@mail.com", "123445");
		userReq = new UserReq();
		userReq.setName("random");
		userReq.setPassword("123");
		
		user = new User();
		user.setUserId(1);
		
		objectMapper = new ObjectMapper();
	}
	
	@Test
	void usersLoginTest() throws Exception {
		when(userService.findByNameAndPassword("random", "123")).thenReturn(userdto);
		
		mockMvc.perform(post("/users/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(userReq)))
		.andExpect(status().is2xxSuccessful())
		.andExpect(jsonPath("$.username").value("random"));
		//verify(userService).findByNameAndPassword(userReq.getName(), userReq.getPassword());
	}
	
	@Test
	void usersSave() throws Exception {
		when(userService.save()).thenReturn(user);
		
		mockMvc.perform(post("/users/")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().is2xxSuccessful());
	}

}
