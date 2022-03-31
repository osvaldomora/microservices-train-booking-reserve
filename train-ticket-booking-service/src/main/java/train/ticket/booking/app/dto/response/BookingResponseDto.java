package train.ticket.booking.app.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import train.ticket.booking.app.dto.client.train.TrainDto;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingResponseDto {
	
	private String name;
	private String surname;
	private String message;
	private boolean success;
	private TrainDto trainDto;


}
