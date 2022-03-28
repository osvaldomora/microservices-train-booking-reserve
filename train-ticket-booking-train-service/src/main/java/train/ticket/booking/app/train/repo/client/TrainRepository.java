package train.ticket.booking.app.train.repo.client;

import org.springframework.data.jpa.repository.JpaRepository;

import train.ticket.booking.app.train.entity.Train;

public interface TrainRepository extends JpaRepository<Train, Integer> {
	
	

}
