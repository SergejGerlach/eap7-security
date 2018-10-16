package de.sergejgerlach.security.valve;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.logging.Logger;

public class TestLoginValve extends ValveBase {

    private static final Logger log = Logger.getLogger(TestLoginValve.class.getName());

    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        log.config("=== entry invoke ===");
        request.addHeader("User-Name", "Sergej");
        getNext().invoke(request, response);
    }
}