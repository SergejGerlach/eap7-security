package de.sergejgerlach.security.servlet.control;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.logging.Logger;

public class LoggerHelper {

    public static void logRequestHeader(HttpServletRequest request, Logger log) {
        final Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerItem = headerNames.nextElement();
            log.config("Header : " + headerItem + " = " + request.getHeader(headerItem));
        }
    }

    public static void logRequestSecurity(HttpServletRequest request, Logger log) {
        log.config("Authentication type : " + request.getAuthType());
        log.config("UserPrincipal : " + request.getUserPrincipal());
    }
}
