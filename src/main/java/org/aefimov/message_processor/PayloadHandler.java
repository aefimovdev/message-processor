package org.aefimov.message_processor;

import org.aefimov.message_processor.exception.HandlerExecutionException;
import org.aefimov.message_processor.wrapper.IPayloadWrapper;

public interface PayloadHandler<T extends IPayloadWrapper> {

    void execute(T message) throws HandlerExecutionException;

}
