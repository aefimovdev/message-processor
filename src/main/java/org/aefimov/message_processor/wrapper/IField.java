package org.aefimov.message_processor.wrapper;

import org.aefimov.message_processor.exception.ChangeValueException;
import org.aefimov.message_processor.exception.InvalidArgumentException;
import org.aefimov.message_processor.exception.ReadValueException;

public interface IField {

    <T> T in(final IPayloadWrapper env) throws ReadValueException, InvalidArgumentException;

    <T> T in(final IPayloadWrapper env, final Class type) throws ReadValueException, InvalidArgumentException;

    <T> void out(final IPayloadWrapper env, final T value) throws ChangeValueException, InvalidArgumentException;

}
