package com.in28minutes.rest.webservice.restfulwebservice.helloWorld;

public class HelloWorldBean {
    public HelloWorldBean() {
    }
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public HelloWorldBean(String message) {
        this.message=message;

    }

    @Override
    public String toString() {
        return "helloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
