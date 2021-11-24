package com.estudo.microservice.hrpayroll.service;

import com.estudo.microservice.hrpayroll.entities.Payment;
import com.estudo.microservice.hrpayroll.entities.Worker;
import com.estudo.microservice.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public ResponseEntity<Payment> getPayment(Long workerId, Integer days) {
        ResponseEntity<Worker> workerResponseEntity = workerFeignClient.findById(workerId);

        if(HttpStatus.NOT_FOUND.value() == workerResponseEntity.getStatusCode().value()){
            return ResponseEntity.notFound().build();
        }
        Worker worker = workerResponseEntity.getBody();
        Payment payment = new Payment(worker.getName(), worker.getDailyIncome(), days);

        return ResponseEntity.ok(payment);

    }
}
