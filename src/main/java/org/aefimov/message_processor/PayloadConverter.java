package org.aefimov.message_processor;

public interface PayloadConverter<F, T> {

    void convert(F from, T to);

}
