package mock.paymentgateway.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
@Slf4j
public class Config extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Config(BCryptPasswordEncoder bCryptPasswordEncoder){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        try {
            auth
                    .inMemoryAuthentication()
                    .withUser(SecurityService.getUsernames(1))
                    .password(bCryptPasswordEncoder.encode(SecurityService.getPassword(1)))
                    .roles("USER")
                    .and()
                    .withUser(SecurityService.getUsernames(0))
                    .password(bCryptPasswordEncoder.encode(SecurityService.getPassword(0)))
                    .roles("USER");
        } catch (Exception e){
            Logger.getLogger(String.valueOf(e));
        }
    }

    @Override
    protected void configure(HttpSecurity http){
        try {
            http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/user/authenticate").hasRole("USER")
                    .and()
                    .httpBasic();
        } catch (Exception e){
            Logger.getLogger(String.valueOf(e));
        }
    }

}
