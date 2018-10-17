package de.sergejgerlach.security.servlet.valve;

import de.sergejgerlach.security.servlet.control.LoggerHelper;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.logging.Logger;

public class HeaderValve extends ValveBase {

    private static final Logger log = Logger.getLogger(HeaderValve.class.getName());

    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        log.config("Entry HeaderValve : invoke");
        request.addHeader("User-Name", "Sergej");
        LoggerHelper.logRequestHeader(request, log);
        LoggerHelper.logRequestSecurity(request, log);
        getNext().invoke(request, response);
    }
}