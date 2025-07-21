package com.github.theinfinity007.springhibernatebootcourse.restcrud.controller;

public class StudentErrorResponse {
    private int status;
    private String message;
    private long timestamp;
    private String errorCode;

    public StudentErrorResponse(){}

    public StudentErrorResponse(int status, String message, long timestamp, String code) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.errorCode = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "StudentErrorResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}
