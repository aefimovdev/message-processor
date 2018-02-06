package org.aefimov.message_processor.iterator;

import org.aefimov.message_processor.route.RouteItem;

public interface PipelineIterator {
    boolean hasNext();

    RouteItem next();

    void first(int position);

    void reset();
}
