package train.ticket.booking.app.user.service.imp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import train.ticket.booking.app.user.dto.request.UserDTO;
import train.ticket.booking.app.user.entity.User;
import train.ticket.booking.app.user.repo.UserRepo;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
	@Mock
	private UserRepo userRepo;
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	private UserDTO userDto;
	private User user;
	
	@BeforeEach
	void setUp() {
		userDto = new UserDTO("random", "random@mail.com", "123445");
		user = new User();
		user.setUserId(1);
		user.setUsername("random");
		user.setPassword("123");
		user.setEmail("random@mail.com");
		user.setPhoneNo("123445");
	}
	
	@Test
	void findByNameAndPasswordTest() {
		when(userRepo.findByUsernameAndPassword("random", "123")).thenReturn(Optional.of(userDto));
		
		UserDTO userDtoRes = userServiceImpl.findByNameAndPassword("random", "123");
		
		assertNotNull(userDtoRes);
		assertEquals(userDtoRes.getUsername(), user.getUsername());
		
	}
	
	@Test
	void saveTest() {
		when(userRepo.save(any(User.class))).thenAnswer(i -> {
			User user = i.getArgument(0);
			user.setUserId(2);
			return user;
		});
		User user2 = userServiceImpl.save();
		
		assertNotNull(user2);
		assertEquals(2, user2.getUserId());
		
		
	}

}
