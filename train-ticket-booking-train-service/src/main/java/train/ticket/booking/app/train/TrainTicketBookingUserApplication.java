package train.ticket.booking.app.train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class TrainTicketBookingUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainTicketBookingUserApplication.class, args);
	}

}
