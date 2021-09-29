package mock.paymentgateway.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.logging.Logger;

import mock.paymentgateway.security.securityService;

@Configuration
@EnableWebSecurity
@Slf4j
public class config extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        try {
            auth
                    .inMemoryAuthentication()
                    .withUser(securityService.getUsernames(1))
                    .password(getBCryptPasswordEncoder().encode("gatewayuser"))
                    .roles("USER")
                    .and()
                    .withUser(securityService.getUsernames(0))
                    .password(getBCryptPasswordEncoder().encode("pratham"))
                    .roles("USER");
        } catch (Exception e){
            Logger.getLogger(String.valueOf(e));
        }
    }

    @Override
    protected void configure(HttpSecurity http){
        try {
            http.authorizeRequests()
                    .antMatchers("/user/authenticate", "/", "/secure/auth").hasRole("USER")
//                    .antMatchers("/", "jsptrial").permitAll()
                    .and()
                    .formLogin();
        } catch (Exception e){
            Logger.getLogger(String.valueOf(e));
        }
    }

    @Bean
    protected BCryptPasswordEncoder getBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
