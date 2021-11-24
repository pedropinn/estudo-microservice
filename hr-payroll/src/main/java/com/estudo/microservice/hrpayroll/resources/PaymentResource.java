package com.estudo.microservice.hrpayroll.resources;

import com.estudo.microservice.hrpayroll.entities.Payment;
import com.estudo.microservice.hrpayroll.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @RequestMapping(value = "/{workerId}/days/{days}", method = RequestMethod.GET)
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
        return service.getPayment(workerId, days);
    }

    public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {

        return ResponseEntity.notFound().build();
    }
}
