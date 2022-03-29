package train.ticket.booking.app.train.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import train.ticket.booking.app.train.repo.client.RouteRepo;
import train.ticket.booking.app.train.repo.client.TrainRepository;
import train.ticket.booking.app.train.service.imp.TrainServiceImpl;

@ExtendWith(MockitoExtension.class)
class TrainServiceImplTest {
	@Mock
	private TrainRepository trainRepository;
	@Mock
	private RouteRepo routeRepo;
	
	@InjectMocks
	private TrainServiceImpl trainServiceImpl;
	
	@BeforeEach
	public void setUp() {
		
	}
	
	@Test
	void findByIdTest() {
		
		fail("Not yet implemented");
	}

}
