package org.aefimov.message_processor.wrapper;

public class PayloadWrapperFactory {

    public static IPayloadWrapper getInstance() {
        return new PayloadWrapperImpl();
    }

}
