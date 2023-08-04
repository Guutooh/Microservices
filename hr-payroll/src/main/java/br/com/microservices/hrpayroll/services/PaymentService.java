package br.com.microservices.hrpayroll.services;

import br.com.microservices.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {


    public Payment getPayment (long workerId, int days){
        return new Payment("Gustavo", 200.00, days);
    }


}
