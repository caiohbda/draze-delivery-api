package draze.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DrazeDeliveryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrazeDeliveryApiApplication.class, args);
	}
}
