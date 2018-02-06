package org.aefimov.message_processor.exception;

public class ChangeValueException extends Exception {

    public ChangeValueException(String message) {
        super(message);
    }

    public ChangeValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
