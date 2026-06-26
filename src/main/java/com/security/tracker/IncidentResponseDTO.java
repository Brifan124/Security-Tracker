package com.security.tracker;

public class IncidentResponseDTO {

    private final Integer id;
    private final String title;
    private final String severity;
    private final String status;
    private final String formattedDate;

    public IncidentResponseDTO(Incident incident){
        this.id = incident.getId();
        this.title = incident.getTitle();
        this.severity = incident.getSeverity();
        this.status = incident.getStatus();

        if(incident.getCreatedAt() != null){
            this.formattedDate = incident.getCreatedAt().toString().substring(0, 16).replace("T", "");
        }
        else {
            this.formattedDate = null;
        }


    }

    public Integer getId() {return id;}

    public String getTitle() {return title;}

    public String getSeverity() {return severity;}

    public String getStatus() {return status;}

    public String getFormattedDate(){return formattedDate;}
}
