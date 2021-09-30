package mock.paymentgateway;


import mock.paymentgateway.security.passwordHashing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@SpringBootApplication
@Component
public class PaymentgatewayApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {

		SpringApplication.run(PaymentgatewayApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
