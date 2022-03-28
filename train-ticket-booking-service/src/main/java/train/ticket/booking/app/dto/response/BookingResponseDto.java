package train.ticket.booking.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import train.ticket.booking.app.dto.client.TrainDto;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDto {
	
	private String name;
	private String surname;
	private TrainDto trainDto;


}
