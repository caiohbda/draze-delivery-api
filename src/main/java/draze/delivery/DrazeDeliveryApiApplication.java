package draze.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ConfigurableApplicationContext;
=======
>>>>>>> 22d5989361137606581ffead2a83868f70251403

@SpringBootApplication
public class DrazeDeliveryApiApplication {

	public static void main(String[] args) {
<<<<<<< HEAD
		SpringApplication app = new SpringApplication(DrazeDeliveryApiApplication.class);
		app.setDefaultProperties(java.util.Collections.singletonMap("server.port", "8081"));
		app.run(args);
	}
=======
		SpringApplication.run(DrazeDeliveryApiApplication.class, args);
	}

>>>>>>> 22d5989361137606581ffead2a83868f70251403
}
