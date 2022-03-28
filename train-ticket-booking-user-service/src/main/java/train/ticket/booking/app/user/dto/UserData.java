package train.ticket.booking.app.user.dto;

import java.time.LocalDate;

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
	private String name;
	private String surname;
	private LocalDate date;
	private Integer trainId;

}
