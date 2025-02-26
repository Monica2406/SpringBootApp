package com.learning.SpringBootApp.Exception;

public class ResourceNotFoundException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s with %s = %s not found", resourceName, fieldName, fieldValue)); // ✅ Fix: Calls RuntimeException constructor
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public long getFieldValue() {
        return fieldValue;
    }
}
