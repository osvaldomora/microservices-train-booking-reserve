package train.ticket.booking.app.passenger.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer PassengerId;
	private Integer BookingId;
	private String name;
	private String surname;
	
}
