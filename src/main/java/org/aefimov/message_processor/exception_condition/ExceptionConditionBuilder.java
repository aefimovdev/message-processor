package org.aefimov.message_processor.exception_condition;

import org.aefimov.message_processor.IRoute;

import java.util.HashMap;
import java.util.Map;

public class ExceptionConditionBuilder {

    private final Map<Class<? extends Exception>, IRoute> inner;

    public ExceptionConditionBuilder() {
        this.inner = new HashMap<>();
    }

    public ExceptionConditionBuilder append(Class<? extends Exception> exClass, IRoute route){
        this.inner.put(exClass, route);
        return this;
    }

    public ExceptionCondition build() {
        return new ExceptionCondition(this.inner);
    }

}
