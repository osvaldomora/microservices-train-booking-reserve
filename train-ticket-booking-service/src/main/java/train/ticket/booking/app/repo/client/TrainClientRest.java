package train.ticket.booking.app.repo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import train.ticket.booking.app.dto.client.train.TrainDto;


@FeignClient(name = "train-service")
public interface TrainClientRest {
	
	@GetMapping("/trains/{train-id}/seats/{seat-number}")
	public TrainDto trains(@PathVariable("train-id") Integer trainId,@PathVariable("seat-number") Integer seatNumber);
	


}
