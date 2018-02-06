package org.aefimov.message_processor.iterator;

import org.aefimov.message_processor.route.Route;
import org.aefimov.message_processor.route.RouteItem;

import java.util.List;

public class RouteItemIterator implements PipelineIterator {

    private final List<RouteItem> routeItems;

    private int currentPosition = 0;

    public RouteItemIterator(Route route) {
        this.routeItems = route.getItems();
    }

    @Override
    public boolean hasNext() {
        return currentPosition < routeItems.size();
    }

    @Override
    public void first(int position) {
        if (currentPosition >= routeItems.size())
            throw new IllegalArgumentException(String
                    .format("An incorrect position argument passed '%s'.", position));
        this.currentPosition = position;

    }

    @Override
    public RouteItem next() {
        if (!hasNext()) {
            return null;
        }
        RouteItem routeItem = routeItems.get(currentPosition);
        currentPosition++;
        return routeItem;
    }

    @Override
    public void reset() {
        this.currentPosition = 0;
    }
}
