package mock.paymentgateway.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
//cors not by-pass
@RestController
public class RequestHandler {


    @GetMapping(path = "/user/authenticate")
    public String authenticateUser(){
       System.out.println("called");
       return "Authenticated!";
   }

}
