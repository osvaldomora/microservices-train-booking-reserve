package train.ticket.booking.app.train.repo.client;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import train.ticket.booking.app.train.entity.Route;

@Repository
public interface RouteRepo extends JpaRepository<Route, Integer>{

	@Query("FROM Route r "
			+ "WHERE source = :sourceT "
			+ "AND destination = :destinationT")
	Optional<Route> findBySearchDetails(String sourceT, String destinationT);

	
}
