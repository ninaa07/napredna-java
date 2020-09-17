package com.naprednajava.NaprednaJava.services;

public class ServiceResult<T> {

    public Boolean success;

    public String message;

    public T resultObject;

    public ServiceResult(Boolean success, String message, T resultObject) {
        this.success = success;
        this.message = message;
        this.resultObject = resultObject;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResultObject() {
        return resultObject;
    }

    public void setResultObject(T resultObject) {
        this.resultObject = resultObject;
    }
}
