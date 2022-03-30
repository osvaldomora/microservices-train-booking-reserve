package train.ticket.booking.app.user.repo;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import train.ticket.booking.app.user.dto.request.UserDTO;
import train.ticket.booking.app.user.entity.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	Optional<UserDTO> findByUsernameAndPassword(String name, String pass);
	
//	@Query("select new com.foodordering.demo.dto.UserDetailsDTO(u.username, u.email, u.phoneNo) FROM User u WHERE u.username = :username")
//	UserDetailsDTO findUsersWithUsername(String username);

}
