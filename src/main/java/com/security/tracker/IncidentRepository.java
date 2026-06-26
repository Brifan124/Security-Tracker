package com.security.tracker;
//soo this is like the engine, it defines what a file can do leaves how to ,to spring
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Integer> {

}
