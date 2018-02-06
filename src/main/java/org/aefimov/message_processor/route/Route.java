package org.aefimov.message_processor.route;

import org.aefimov.message_processor.IRoute;
import org.aefimov.message_processor.iterator.RouteItemIterator;

import java.util.Collections;
import java.util.List;

public class Route implements IRoute {

    private final List<RouteItem> items;

    private final RouteItemIterator iterator;

    Route(List<RouteItem> items) {
        this.items = items;
        this.iterator = new RouteItemIterator(this);
    }

    @Override
    public RouteItemIterator iterator() {
        this.iterator.reset();
        return this.iterator;
    }

    @Override
    public List<RouteItem> getItems() {
        return Collections.unmodifiableList(items);
    }

}
