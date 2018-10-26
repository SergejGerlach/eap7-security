package de.sergejgerlach.security.servlet.handler;

import de.sergejgerlach.security.servlet.control.LoggerHelper;
import org.apache.catalina.connector.Request;
import org.apache.catalina.deploy.LoginConfig;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.logging.Logger;

public class DummyAuthenticatorValve {//extends AuthenticatorBase {

    private static final Logger log = Logger.getLogger(DummyAuthenticatorValve.class.getName());

    // @Override
    protected boolean authenticate(Request request, HttpServletResponse httpServletResponse, LoginConfig loginConfig) throws IOException {
        log.config("Entry DummyAuthenticatorValve : authenticate");
        LoggerHelper.logRequestHeader(request, log);
        LoggerHelper.logRequestSecurity(request, log);

        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            log.config("Already authenticated with principal " + principal);
            return false;
        }

        // principal = this.context.getRealm().authenticate("dummy", "");
        if (principal != null) {
            log.config("Authenticated with principal " + principal);
            request.setUserPrincipal(principal);
            return true;
        }
        return false;
    }
}
