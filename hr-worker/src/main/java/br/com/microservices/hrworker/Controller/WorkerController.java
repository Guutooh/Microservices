package br.com.microservices.hrworker.Controller;

import br.com.microservices.hrworker.entities.Worker;
import br.com.microservices.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/worker")
public class WorkerController {

    @Autowired
    WorkerRepository repository;

    @GetMapping()
    public ResponseEntity<List<Worker>> findAll() {

        List<Worker> list = repository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {

        Worker worker = repository.findById(id).get();

        return ResponseEntity.status(HttpStatus.OK).body(worker);
    }

}
