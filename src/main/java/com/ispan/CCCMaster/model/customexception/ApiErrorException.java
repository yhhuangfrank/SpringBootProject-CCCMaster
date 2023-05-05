package com.ispan.CCCMaster.model.customexception;

public class ApiErrorException extends RuntimeException{

    private final Integer statusCode;

    private final String message;

    public ApiErrorException(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
