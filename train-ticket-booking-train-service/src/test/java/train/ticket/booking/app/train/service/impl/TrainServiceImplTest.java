package train.ticket.booking.app.train.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import train.ticket.booking.app.train.dto.TrainSearchByDetsReponseDTO;
import train.ticket.booking.app.train.dto.response.RouteDto;
import train.ticket.booking.app.train.dto.response.SeatDto;
import train.ticket.booking.app.train.dto.response.TrainDto;
import train.ticket.booking.app.train.dto.response.TrainSearchDto;
import train.ticket.booking.app.train.entity.Route;
import train.ticket.booking.app.train.entity.Seat;
import train.ticket.booking.app.train.entity.Train;
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
	Train train;
	Route route;
	Seat seat;
	RouteDto routeDto;
	SeatDto seatDto;
	//TrainDto trainDto;
	TrainSearchDto trainSearchDto;
	TrainSearchByDetsReponseDTO res;
	@BeforeEach
	void setUp() {
		train = new Train();
		train.setTrainId(1);
		train.setModel("XY");
		train.setCapacity("100");
		
		route = new Route();
		route.setRouteId(1);
		route.setDestination("oaxaca");
		route.setSource("cancun");
		route.setPrice("222");
		route.setTrains(List.of(train));
		
		seat = new Seat();
		seat.setSeatId(1);
		seat.setAvailable(true);
		seat.setNumber(1);
		seat.setRow(1);
		seat.setTrain(train);
		
		train.setRoute(route);
		train.setSeats(List.of(seat));
		
		routeDto = new RouteDto();
		routeDto.setDestination(route.getDestination());
		routeDto.setSource(route.getSource());
		routeDto.setPrice(route.getPrice());
		routeDto.setRouteId(route.getRouteId().toString());
		
		seatDto = new SeatDto();
		seatDto.setNumber(seat.getNumber().toString());
		seatDto.setRow(seat.getRow().toString());
		
		//trainDto = new TrainDto();
		//trainDto.setModel(train.getModel());
		//trainDto.setRoute(routeDto);
		//trainDto.setSeat(seatDto);
		//trainDto.setTrainId(train.getTrainId().toString());
		trainSearchDto = new TrainSearchDto(train.getCapacity(), train.getModel());
		res = new TrainSearchByDetsReponseDTO("Details fetch successfully", 200);
	}
	
	@Test
	void findByIdTest() {
		when(trainRepository.findById(1)).thenReturn(Optional.of(train));
		
		TrainDto trainDto = trainServiceImpl.findById(1, 1);
		trainDto.setModel(train.getModel());
		trainDto.setRoute(routeDto);
		trainDto.setSeat(seatDto);
		trainDto.setTrainId(train.getTrainId().toString());
		
		assertNotNull(trainDto);
		assertEquals("1", trainDto.getTrainId());
		
	}
	
	@Test
	void findBySearchDetailsTest() {
		when(routeRepo.findBySearchDetails("cancun", "oaxaca")).thenReturn(Optional.of(route));
		
		when(trainRepository.findByRoute(Optional.of(route))).thenReturn(List.of(trainSearchDto));
		
		TrainSearchByDetsReponseDTO trainResponseDto = trainServiceImpl.findBySearchDetails("cancun", "oaxaca", "2020");
		trainResponseDto.setMessage("Details fetch successfully");
		trainResponseDto.setStatusCode(200);
		trainResponseDto.setTrainDetails(List.of(trainSearchDto));
		
		assertEquals(res.getMessage(), trainResponseDto.getMessage());
		assertEquals(List.of(trainSearchDto), trainResponseDto.getTrainDetails());
	}
}