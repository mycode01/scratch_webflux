package com.example.scratchwebflux;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
//  Flux<Person> findAll();

  List<Person> findAll();
}
