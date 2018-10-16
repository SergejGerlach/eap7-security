package de.sergejgerlach.security.valve;

import org.apache.catalina.authenticator.AuthenticatorBase;
import org.apache.catalina.connector.Request;
import org.apache.catalina.deploy.LoginConfig;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.logging.Logger;

public class DummyAuthenticatorValve extends AuthenticatorBase {

    private static final Logger log = Logger.getLogger(DummyAuthenticatorValve.class.getName());

    @Override
    protected boolean authenticate(Request request, HttpServletResponse httpServletResponse, LoginConfig loginConfig) throws IOException {
        log.config("=== entry DummyAuthenticatorValve authenticate ===");
        final Principal principal = this.context.getRealm().authenticate("dummy", "");
        if (principal != null) {
            log.config("=== authenticate with principal " + principal + " ===");
            request.setUserPrincipal(principal);
            return true;
        }
        return false;
    }
}
