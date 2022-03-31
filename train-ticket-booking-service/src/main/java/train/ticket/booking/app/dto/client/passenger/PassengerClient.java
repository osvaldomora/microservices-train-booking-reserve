package train.ticket.booking.app.dto.client.passenger;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassengerClient {

	private Integer PassengerId;
	private Integer userId;
	private Integer BookingId;
	private Integer seatId;
	private String name;
	private String surname;
	
}
