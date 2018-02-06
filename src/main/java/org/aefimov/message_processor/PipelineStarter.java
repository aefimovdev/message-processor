package org.aefimov.message_processor;

import org.aefimov.message_processor.route.Route;
import org.aefimov.message_processor.route.RouteBuilder;
import org.aefimov.message_processor.route.RouteItem;
import org.aefimov.message_processor.wrapper.IPayloadWrapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PipelineStarter {

    private final Route route;
    private final Map<Class<? extends Exception>, Route> exceptionRouteCondition;
    private final Pipeline pipeline;

    public PipelineStarter(
            Pipeline pipeline,
            List<RouteItem> routeItems,
            Map<Class<? extends Exception>, List<RouteItem>> exceptionRouteCondition) {
        this.pipeline = pipeline;
        this.exceptionRouteCondition = prepareExRouteCondition(exceptionRouteCondition);

        RouteBuilder routeBuilder = new RouteBuilder();
        this.route = routeBuilder.appendItems(routeItems).build();
    }

    public void execute(IPayloadWrapper wrapper) {
        PipelineObject<IPayloadWrapper> pipelineObject =
                new PipelineObject<>(this.route, this.exceptionRouteCondition, wrapper);
        pipeline.execute(pipelineObject);
    }

    private Map<Class<? extends Exception>, Route> prepareExRouteCondition(
            Map<Class<? extends Exception>, List<RouteItem>> exceptionRouteCondition) {

        Map<Class<? extends Exception>, Route> result = new HashMap<>();
        for (Map.Entry<Class<? extends Exception>, List<RouteItem>> condition : exceptionRouteCondition.entrySet()) {
            List<RouteItem> routeItems = condition.getValue();
            RouteBuilder routeBuilder = new RouteBuilder();
            Route route = routeBuilder.appendItems(routeItems).build();
            result.put(condition.getKey(), route);
        }
        return result;
    }


}
