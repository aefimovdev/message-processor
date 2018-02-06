package org.aefimov.message_processor.exception_condition;

import org.aefimov.message_processor.IRoute;

import java.util.Collections;
import java.util.Map;

public class ExceptionCondition {

    private final Map<Class<? extends Exception>, IRoute> inner;

    ExceptionCondition(Map<Class<? extends Exception>, IRoute> inner) {
        this.inner = inner;
    }

    public Map<Class<? extends Exception>, IRoute> condition(){
        return Collections.unmodifiableMap(this.inner);
    }

}
