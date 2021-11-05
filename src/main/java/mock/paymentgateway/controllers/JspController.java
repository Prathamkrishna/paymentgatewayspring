package mock.paymentgateway.controllers;

import mock.paymentgateway.data.PaymentRepository;
import mock.paymentgateway.model.Userdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JspController {

    private final PaymentRepository paymentRepository;

    @Autowired
    JspController(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    @PostMapping(path = "/secure/auth")
    public String securePayment(Model model, @RequestBody Userdata userdata) {
//        paymentRepository.updateDatabase(userdata.getName(), userdata.getAmount());
        model.addAttribute("name", userdata.getName());
        model.addAttribute("amount", userdata.getAmount());
        return "securepayment";
    }

    @GetMapping(value = "/")
    public String indexPage() {
        return "index";
    }
}
