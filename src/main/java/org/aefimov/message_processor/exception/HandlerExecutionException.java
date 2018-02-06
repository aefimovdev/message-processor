package org.aefimov.message_processor.exception;

public class HandlerExecutionException extends Exception {

    public HandlerExecutionException(String message) {
        super(message);
    }

    public HandlerExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}
