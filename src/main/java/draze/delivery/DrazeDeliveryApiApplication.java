package draze.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DrazeDeliveryApiApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DrazeDeliveryApiApplication.class);
		app.setDefaultProperties(java.util.Collections.singletonMap("server.port", "8081"));
		app.run(args);
	}
}
