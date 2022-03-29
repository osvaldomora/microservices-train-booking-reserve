package train.ticket.booking.app.passenger.dto;

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
public class BookingReqDto {
	
	private Integer bookingId;
	private String name;
	private String surname;
	
}


