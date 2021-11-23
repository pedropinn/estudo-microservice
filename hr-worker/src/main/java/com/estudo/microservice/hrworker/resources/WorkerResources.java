package com.estudo.microservice.hrworker.resources;

import com.estudo.microservice.hrworker.entities.Worker;
import com.estudo.microservice.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResources {

    @Autowired
    private WorkerRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Worker>> findall(){
        return ResponseEntity.ok(repository.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Optional<Worker> worker = repository.findById(id);
        return worker.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
