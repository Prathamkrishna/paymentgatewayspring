package mock.paymentgateway.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class requesthandler {
   @GetMapping("/user/authenticate")
    public String authenticateUser(){

       return "Authenticate!";
   }

}
