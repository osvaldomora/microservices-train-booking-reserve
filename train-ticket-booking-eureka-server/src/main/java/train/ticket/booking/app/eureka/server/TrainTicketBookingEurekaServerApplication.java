package train.ticket.booking.app.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TrainTicketBookingEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainTicketBookingEurekaServerApplication.class, args);
	}

}
