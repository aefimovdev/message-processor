package org.aefimov.message_processor;

import org.aefimov.message_processor.exception.HandlerExecutionException;
import org.aefimov.message_processor.exception.RouteNotFoundException;
import org.aefimov.message_processor.iterator.RouteItemIterator;
import org.aefimov.message_processor.route.Route;
import org.aefimov.message_processor.route.RouteItem;
import org.aefimov.message_processor.wrapper.IPayloadWrapper;

import java.util.Map;

public class PipelineImpl implements Pipeline {

//    private static final Logger LOG = Logger.getLogger(PipelineImpl.class);

    public PipelineImpl() {
    }

    public void execute(final PipelineObject object) {
        IRoute route = object.getRoute();
        Map<Class<? extends Exception>, Route> exceptionRouteCondition =
                object.getExceptionRouteCondition();

        IPayloadWrapper payload = (IPayloadWrapper) object.getPayload();
        try {
            processRoute(route, payload);
        } catch (Exception e) {
//            LOG.warn("The pipeline route was aborted by exception.\r\n" +
//                    "Will be executed the selected for this situation an exception route.", e);

            Class<? extends Exception> thrownExClass = e.getClass();
            try {
                Route currentExRoute = exceptionRouteCondition.get(thrownExClass);
                if (null == currentExRoute)
                    throw new RouteNotFoundException(e.getMessage(), e);
                processRoute(currentExRoute, payload);
            } catch (RouteNotFoundException e1) {
//                LOG.error(String.format("No route for exception '%s' found.", thrownExClass.getCanonicalName()));
//                LOG.error("The stack trace of unhandled exception.", e1);
            } catch (HandlerExecutionException e2) {
//                LOG.error("An unexpected error occurred when perform the exception route.", e2);
            }
        }

    }

    private void processRoute(IRoute route, IPayloadWrapper payload) throws HandlerExecutionException {
        RouteItemIterator iterator = route.iterator();
        while (iterator.hasNext()) {
            RouteItem routeItem = iterator.next();
            PayloadHandler<IPayloadWrapper> handler = routeItem.getHandler();
            String handlerName = routeItem.getName();
//            LOG.debug(String.format("Pipeline route item processor. Begin execute the handler '%s'.", handlerName));
//            LOG.debug(String.format("Pipeline route item processor. The handler will execute the message %s.", payload.toString()));
            handler.execute(payload);
//            LOG.debug(String.format("Pipeline route item processor. The handler '%s' was executed.", handlerName));
        }
    }

}
