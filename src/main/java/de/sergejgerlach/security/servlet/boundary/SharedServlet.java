
package de.sergejgerlach.security.servlet.boundary;

import de.sergejgerlach.security.servlet.control.HtmlWriter;
import de.sergejgerlach.security.servlet.control.LoggerHelper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

/**
 * A simple shared HTTP servlet.
 *
 */
@WebServlet("/shared")
public class SharedServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(SharedServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.config("Entry SharedServlet");
        LoggerHelper.logRequestHeader(request, log);
        LoggerHelper.logRequestSecurity(request, log);
        try (PrintWriter writer = response.getWriter()) {
            String body = "NO NEED AUTHENTICATED USER";
            HtmlWriter.writePage(writer, "Hello from Shared Servlet!", body);
        }
    }


}
