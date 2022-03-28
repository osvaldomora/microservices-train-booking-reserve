package train.ticket.booking.app.dto;

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
public class UserData {
	
	private Integer userId;
	private String username;
	private String password;
	private Integer trainId;
	private Integer seatNumber;


}
