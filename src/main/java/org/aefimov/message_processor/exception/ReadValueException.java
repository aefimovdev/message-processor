package org.aefimov.message_processor.exception;

public class ReadValueException extends Exception {

    public ReadValueException(String message) {
        super(message);
    }

    public ReadValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
