package org.aefimov.message_processor.exception;

public class RouteNotFoundException extends HandlerExecutionException {

    public RouteNotFoundException(String message) {
        super(message);
    }

    public RouteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
