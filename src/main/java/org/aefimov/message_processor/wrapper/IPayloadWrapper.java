package org.aefimov.message_processor.wrapper;

import org.aefimov.message_processor.exception.ChangeValueException;
import org.aefimov.message_processor.exception.InvalidArgumentException;
import org.aefimov.message_processor.exception.ReadValueException;

public interface IPayloadWrapper {

    Object getValue(String fieldName) throws ReadValueException, InvalidArgumentException;

    void setValue(String fieldName, Object value) throws InvalidArgumentException, ChangeValueException;

}
