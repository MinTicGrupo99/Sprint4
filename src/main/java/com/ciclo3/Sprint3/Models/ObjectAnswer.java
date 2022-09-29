package com.ciclo3.Sprint3.Models;

public class ObjectAnswer {

    private Object object;
    private String message;

    public ObjectAnswer(String message, Object object) {
        this.object = object;
        this.message = message;
    }

    public ObjectAnswer() {
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
