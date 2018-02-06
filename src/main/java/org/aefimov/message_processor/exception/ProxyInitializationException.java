package org.aefimov.message_processor.exception;

public class ProxyInitializationException extends Exception {

    public ProxyInitializationException(String message) {
        super(message);
    }

    public ProxyInitializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
