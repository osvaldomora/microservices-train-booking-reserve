package train.ticket.booking.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class TrainTicketBookingUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainTicketBookingUserApplication.class, args);
	}

}
