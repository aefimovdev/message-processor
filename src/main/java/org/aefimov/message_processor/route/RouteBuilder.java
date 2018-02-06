package org.aefimov.message_processor.route;

import org.aefimov.message_processor.route.Route;
import org.aefimov.message_processor.route.RouteItem;

import java.util.ArrayList;
import java.util.List;

public class RouteBuilder {

    private List<RouteItem> routeItems;

    public RouteBuilder() {
        this.routeItems = new ArrayList<>();
    }

    public RouteBuilder appendItems(List<RouteItem> items){
        this.routeItems.addAll(items);
        return this;
    }

    public RouteBuilder appendItem(RouteItem item) {
        this.routeItems.add(item);
        return this;
    }

    public Route build() {
        return new Route(this.routeItems);
    }

}

