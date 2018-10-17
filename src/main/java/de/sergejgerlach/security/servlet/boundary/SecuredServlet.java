package de.sergejgerlach.security.servlet.boundary;

import de.sergejgerlach.security.servlet.control.HtmlWriter;
import de.sergejgerlach.security.servlet.control.LoggerHelper;

import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.logging.Logger;

/**
 * A simple secured HTTP servlet.
 *
 */
@WebServlet("/secured")
@ServletSecurity(httpMethodConstraints = { @HttpMethodConstraint(value = "GET", rolesAllowed = { "SuperUser" }) })
public class SecuredServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(SecuredServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.config("Entry SecuredServlet");
        try (PrintWriter writer = response.getWriter()) {
            LoggerHelper.logRequestHeader(request, log);
            LoggerHelper.logRequestSecurity(request, log);
            Principal user = request.getUserPrincipal();
            String body = "Current Principal '" + (user != null ? user.getName() : "NO AUTHENTICATED USER") + "'";
            HtmlWriter.writePage(writer, "Hello from Secured Servlet", body);
        }
    }
}
