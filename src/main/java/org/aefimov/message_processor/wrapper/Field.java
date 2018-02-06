package org.aefimov.message_processor.wrapper;


import org.aefimov.message_processor.exception.ChangeValueException;
import org.aefimov.message_processor.exception.InvalidArgumentException;
import org.aefimov.message_processor.exception.ReadValueException;

public class Field implements IField {

    private final String fieldName;

    private Field(String fieldName) throws InvalidArgumentException {
        if (fieldName == null || fieldName.isEmpty())
            throw new InvalidArgumentException("Field name should not be null or empty");
        this.fieldName = fieldName;
    }

    public static IField getInstance(String fieldName) throws InvalidArgumentException {
        return new Field(fieldName);
    }

    @Override
    public <T> T in(IPayloadWrapper env) throws ReadValueException, InvalidArgumentException {
        if (env == null)
            throw new InvalidArgumentException("Argument should not be null.");

        return (T) env.getValue(this.fieldName);
    }

    @Override
    public <T> T in(IPayloadWrapper env, Class type) throws ReadValueException, InvalidArgumentException {
        if (null == env || null == type) {
            throw new InvalidArgumentException("Argument should not be null.");
        }
        Object value = env.getValue(fieldName);
        if (null == value) {
            return null;
        }
        if (type == value.getClass() || type.isAssignableFrom(value.getClass())) {
            return (T) value;
        }
        throw new InvalidArgumentException("Could not cast value - " + value.getClass().getCanonicalName() +
                " to required type - " + type.getCanonicalName() + ".");
    }

    @Override
    public <T> void out(IPayloadWrapper env, T value) throws ChangeValueException, InvalidArgumentException {
        if (env == null) {
            throw new InvalidArgumentException("Argument should not be null.");
        }
        env.setValue(this.fieldName, value);
    }
}
