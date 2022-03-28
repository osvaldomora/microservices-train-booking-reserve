package train.ticket.booking.app.train.service.imp;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import train.ticket.booking.app.train.dto.TrainSearchByDetsReponseDTO;
import train.ticket.booking.app.train.dto.response.RouteDto;
import train.ticket.booking.app.train.dto.response.SeatDto;
import train.ticket.booking.app.train.dto.response.TrainDto;
import train.ticket.booking.app.train.dto.response.TrainSearchDto;
import train.ticket.booking.app.train.entity.Route;
import train.ticket.booking.app.train.entity.Seat;
import train.ticket.booking.app.train.entity.Train;
import train.ticket.booking.app.train.exceptions.RouteIsNotFoundByDetailsException;
import train.ticket.booking.app.train.repo.client.RouteRepo;
import train.ticket.booking.app.train.repo.client.TrainRepository;
import train.ticket.booking.app.train.service.ITrainService;


@Service
public class TrainServiceImpl implements ITrainService{
	

	@Autowired
	TrainRepository trainRepository;
	@Autowired
	RouteRepo routeRepo;

	@Override
	public TrainDto findById(Integer trainId, Integer seatNumber) {
		Train train = trainRepository.findById(trainId).get();
		
		return mappingDto(train,trainId,seatNumber);
	}

	private TrainDto mappingDto(Train train,Integer trainId, Integer seatNumber) {
		//mandar exception
		Seat  seat=train.getSeats().stream().filter(x->x.getNumber()==seatNumber && x.isAvailable()).findFirst().get();//lanzar excepcion si el asiento esta ocupado
		RouteDto route = new RouteDto();
		route.setDestination(train.getRoute().getDestination());
		route.setPrice("222");
		route.setRouteId(train.getRoute().getRouteId().toString());
		route.setSource(train.getRoute().getSource());
		
		SeatDto seatDto = new SeatDto();
		seatDto.setNumber(seat.getNumber().toString());
		seatDto.setRow(seat.getRow().toString());
		
		TrainDto tr = new TrainDto();
		tr.setModel(train.getModel());
		tr.setRoute(route);
		tr.setSeat(seatDto);
		tr.setTrainId(train.getTrainId().toString());
				
		return tr;
	}

	@Override
	public TrainSearchByDetsReponseDTO findBySearchDetails(String sourceT, String destinationT, String dateT) {
		// TODO Auto-generated method stub
		
		Optional<Route> routeid = routeRepo.findBySearchDetails(sourceT, destinationT);
		
		if(routeid.isEmpty()) {
			throw new RouteIsNotFoundByDetailsException("No Route found with details: " + sourceT + ", " + destinationT);
		}
		
		List<TrainSearchDto> trainSearchDto = trainRepository.findByRoute(routeid);
		
		
		
		TrainSearchByDetsReponseDTO trainResponseDto = new TrainSearchByDetsReponseDTO("Details fetch successfully", 200);
		trainResponseDto.setTrainDetails(trainSearchDto);
		
		return trainResponseDto;
	}

	



}
