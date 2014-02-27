package com.xebia.fitnesse.meetup.slim.fixtures;

public class StopTestException extends RuntimeException {
    public StopTestException(String message, Throwable t) {
        super(message, t);
    }
}
