package com.security.tracker;


//This is the blueprint of our app
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "incidents")

public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private LocalDateTime createdAt;
    private Integer id;
    @NotBlank(message = "incident title cannot be empty")
    @Size(max = 100, min = 2, message = "title should be between 2 and 100 characters")

    private String title;
    private String severity;
    private String status;

    public Incident(){}


    public Incident(Integer id, String title, String severity, String status){
        this.id = id;
        this.title = title;
        this.severity = severity;
        this.status = status;
    }

    public Integer getId(){return id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle(){return title;}

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeverity(){return severity;}

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus(){return status;}

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt(){return createdAt;}

    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}
}
