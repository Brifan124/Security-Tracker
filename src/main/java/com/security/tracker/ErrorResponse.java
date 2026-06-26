package com.security.tracker;
//this cleans up error messages and presents them in a professional looking manner
public class ErrorResponse {
    private String error;
    private String message;

    public ErrorResponse(String error, String message){
        this.error = error;
        this.message = message;
    }

    public String getError() {return error;}
    public void setError(){this.error = error;}

    public String getMessage(){return message;}

    public void setMessage(String message) {this.message = message;}
}
