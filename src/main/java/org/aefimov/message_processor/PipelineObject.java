package org.aefimov.message_processor;

import org.aefimov.message_processor.route.Route;

import java.util.Date;
import java.util.Map;

public class PipelineObject<T> {

    private Date createdDate;
    private Route route;
    private Map<Class<? extends Exception>, Route> exceptionRouteCondition;
    private T payload;

    public PipelineObject(Route route,
                          Map<Class<? extends Exception>, Route> exceptionRouteCondition,
                          T payload) {
        this.payload = payload;
        this.createdDate = new Date();
        this.route = route;
        this.exceptionRouteCondition = exceptionRouteCondition;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    Route getRoute() {
        return route;
    }

    Map<Class<? extends Exception>, Route> getExceptionRouteCondition() {
        return exceptionRouteCondition;
    }
}
