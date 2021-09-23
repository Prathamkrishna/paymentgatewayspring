package mock.paymentgateway.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class jspcontroller {
    @RequestMapping("/secure/auth")
    public String securePayment(Model model){
        model.addAttribute("name", "pratham");
        model.addAttribute("amount", 300);
        return "securepayment";
    }
    @RequestMapping("/")
    public String indexPage(){
        return "index";
    }
}
