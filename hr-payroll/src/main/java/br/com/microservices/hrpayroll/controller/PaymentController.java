package br.com.microservices.hrpayroll.controller;

import br.com.microservices.hrpayroll.entities.Payment;
import br.com.microservices.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentService service;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment (@PathVariable long workerId, @PathVariable Integer days){
        Payment payment = service.getPayment(workerId,days);

        return ResponseEntity.status(HttpStatus.OK).body(payment);
    }

    public ResponseEntity<Payment> getPaymentAlternative (long workerId, @PathVariable Integer days){
        Payment payment = new Payment("Caminho alternativo", 400.0, days);
        return ResponseEntity.ok(payment);
    }


}
