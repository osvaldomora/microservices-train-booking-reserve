package train.ticket.booking.app.train.repo.client;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import train.ticket.booking.app.train.dto.response.TrainSearchDto;
import train.ticket.booking.app.train.entity.Route;
import train.ticket.booking.app.train.entity.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {
	
	//@Query("select new com.foodordering.demo.dto.UserDetailsDTO(u.username, u.email, u.phoneNo) FROM User u WHERE u.username = :username")
	
	List<TrainSearchDto> findByRoute(Optional<Route> routeid);
}
