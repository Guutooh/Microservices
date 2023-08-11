package br.com.microservices.hruser.repositories;

import br.com.microservices.hruser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User,Long> {


    User findByEmail(String email);

}
