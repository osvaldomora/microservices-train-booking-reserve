package train.ticket.booking.app.dto.client.passanger;

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
public class BookingReqClientDto {
	
	private Integer bookingId;
	private String name;
	private String surname;
	
}


