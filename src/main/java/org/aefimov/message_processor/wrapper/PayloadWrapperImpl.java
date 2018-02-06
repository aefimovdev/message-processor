package org.aefimov.message_processor.wrapper;

import org.aefimov.message_processor.exception.ChangeValueException;
import org.aefimov.message_processor.exception.InvalidArgumentException;
import org.aefimov.message_processor.exception.ReadValueException;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * The default implementation of {@link IPayloadWrapper}.
 */
public class PayloadWrapperImpl implements IPayloadWrapper {

    private final ConcurrentMap<String, Object> body;

    PayloadWrapperImpl() {
        this.body = new ConcurrentHashMap<>();
    }

    @Override
    public Object getValue(String fieldName)
            throws ReadValueException, InvalidArgumentException {
        if (null == fieldName) {
            throw new InvalidArgumentException("FieldName parameter should not be null.");
        }
        return body.get(fieldName);
    }

    @Override
    public void setValue(String fieldName, Object value)
            throws ChangeValueException, InvalidArgumentException {
        if (null == fieldName) {
            throw new InvalidArgumentException("FieldName parameter should not be null.");
        }
        body.put(fieldName, value);
    }

    @Override
    public String toString() {
        return "PayloadWrapperImpl{" +
                "body=" + body.toString() +
                '}';
    }
}
