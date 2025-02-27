package com.learning.SpringBootApp.PayLoad;

public class ApiResponse {
    private String message;
    private boolean success;

    public ApiResponse(String message, boolean success) { 
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
