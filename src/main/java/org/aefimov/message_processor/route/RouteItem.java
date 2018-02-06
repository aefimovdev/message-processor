package org.aefimov.message_processor.route;

import org.aefimov.message_processor.PayloadHandler;
import org.aefimov.message_processor.wrapper.IPayloadWrapper;

public class RouteItem<T extends IPayloadWrapper> {

    private String name;

    private PayloadHandler<T> handler;

    public RouteItem(String name, PayloadHandler<T> handler) {
        this.name = name;
        this.handler = handler;
    }

    public String getName() {
        return name;
    }

    public PayloadHandler<T> getHandler() {
        return handler;
    }


}
