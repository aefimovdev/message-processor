package org.aefimov.message_processor;

import org.aefimov.message_processor.iterator.RouteItemIterator;
import org.aefimov.message_processor.route.RouteItem;

import java.util.List;

public interface IRoute {

    RouteItemIterator iterator();

    List<RouteItem> getItems();

}
