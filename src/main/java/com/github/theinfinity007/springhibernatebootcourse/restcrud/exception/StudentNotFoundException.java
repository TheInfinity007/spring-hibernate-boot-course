package com.github.theinfinity007.springhibernatebootcourse.restcrud.exception;

public class StudentNotFoundException extends RuntimeException {

    String errorCode;

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
