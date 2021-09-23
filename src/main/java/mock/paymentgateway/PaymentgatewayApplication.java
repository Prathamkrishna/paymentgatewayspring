package mock.paymentgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class PaymentgatewayApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(PaymentgatewayApplication.class, args);
	}
}
