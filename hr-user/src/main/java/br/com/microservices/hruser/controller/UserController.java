package br.com.microservices.hruser.controller;

import br.com.microservices.hruser.entities.User;
import br.com.microservices.hruser.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {


    @Autowired
    UserRespository repository;


    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {


        User user = repository.findById(id).get();

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


    @GetMapping("/procura")
    public ResponseEntity<User> findById(@RequestParam String email) {


        User user = repository.findByEmail(email);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


}