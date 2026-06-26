package com.security.tracker;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class IncidentRequestDTO {

    @NotBlank(message = "Title cannot be empty")
    @Size(max = 100, min = 2, message = "Title must be between 2 and 100 characters")
    private String title;

    @NotBlank(message = "Severity level is required")
    private String severity;

    @NotBlank(message = "Status is required")
    private String status;

    public String getTitle() {return title;}
    public void setTitle(String title){this.title = title;}

    public String getSeverity(){return severity;}

    public void setSeverity(String severity) {this.severity = severity;}

    public String getStatus(){return status;}

    public void setStatus(String status) {this.status = status;}

}
