package de.sergejgerlach.security.servlet.auth;

import java.security.Provider;
import java.util.logging.Logger;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

public class HeaderProvider extends Provider {

    private static final Logger log = Logger.getLogger(HeaderProvider.class.getName());

    public HeaderProvider(String name, double version, String info) {
        super(name, version, info);
        log.config("Entry HeaderProvider, name = " + name);
        putService(new Service(this, "xxx", "yyy", HeaderMechanismFactory.class.getName(), emptyList(), emptyMap()));
    }
}
