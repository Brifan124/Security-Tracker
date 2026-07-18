package com.security.tracker;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class IncidentController {
    private  final IncidentRepository incidentRepository;
    public IncidentController (IncidentRepository incidentRepository){
        this.incidentRepository = incidentRepository;
    }

    @GetMapping("/incidents")
    public List<Incident> getAllIncidents(){
        return incidentRepository.findAll();
    }
    @PostMapping("incidents")
    public IncidentResponseDTO createIncident(@Valid @RequestBody IncidentRequestDTO e){
        Incident incident = new Incident();

        incident.setTitle(e.getTitle());
        incident.setSeverity(e.getSeverity());
        incident.setStatus(e.getStatus());
        incident.setCreatedAt(LocalDateTime.now());

        Incident saveIncident = incidentRepository.save(incident);
        return new IncidentResponseDTO(saveIncident);
    }

    @DeleteMapping("/incidents/{id}")
    public String deleteIncident(@PathVariable Integer id){
        if(incidentRepository.existsById(id)){
            incidentRepository.deleteById(id);
            return "Incident ID: " + id + " was removed";
        }

        else {
            return "Error: Incident ID: " + id + "Was not found";
        }
    }

    @PutMapping("/incidents/{id}")
    public Incident updateIncident(@PathVariable Integer id, @RequestBody Incident updatedDetails){
        return incidentRepository.findById(id).map(existingIncident -> {
            existingIncident.setTitle(updatedDetails.getTitle());
            existingIncident.setSeverity(updatedDetails.getSeverity());
            existingIncident.setStatus(updatedDetails.getStatus());

            return incidentRepository.save(existingIncident);

        }).orElseThrow(() -> new RuntimeException("Incident id : " + id + "was not added"));
    }

    public Incident getIncidentById(@PathVariable Integer id){
        return incidentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Incident id " + id + " was not found"));
    }


}
