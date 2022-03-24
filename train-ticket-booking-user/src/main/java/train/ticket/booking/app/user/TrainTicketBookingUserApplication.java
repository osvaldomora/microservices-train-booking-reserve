package train.ticket.booking.app.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TrainTicketBookingUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainTicketBookingUserApplication.class, args);
	}

}
