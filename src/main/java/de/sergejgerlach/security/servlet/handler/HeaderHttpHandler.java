package de.sergejgerlach.security.servlet.handler;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

import java.util.logging.Logger;

// import org.apache.catalina.valves.ValveBase;

public class HeaderHttpHandler implements HttpHandler {

    private static final Logger log = Logger.getLogger(HeaderHttpHandler.class.getName());
    private HttpHandler next;

    public HeaderHttpHandler(HttpHandler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        log.config("Entry HeaderHttpHandler : handleRequest");
        // LoggerHelper.logRequestHeader(exchange.getRequestHeaders(), log);
        // Print Authorization header
        log.config("Header : Authorization = " + exchange.getRequestHeaders().get("Authorization"));
        next.handleRequest(exchange);
    }

/*
    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        log.config("Entry HeaderHttpHandler : invoke");
        LoggerHelper.logRequestHeader(request, log);
        LoggerHelper.logRequestSecurity(request, log);
        getNext().invoke(request, response);
    }
*/
}