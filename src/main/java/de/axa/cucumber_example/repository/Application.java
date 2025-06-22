package de.axa.cucumber_example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Application extends JpaRepository<Application, Long> {

}
