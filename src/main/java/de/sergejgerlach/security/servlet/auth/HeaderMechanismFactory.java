/*
 * Copyright 2018 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.sergejgerlach.security.servlet.auth;

import org.wildfly.security.http.HttpAuthenticationException;
import org.wildfly.security.http.HttpServerAuthenticationMechanism;
import org.wildfly.security.http.HttpServerAuthenticationMechanismFactory;

import javax.security.auth.callback.CallbackHandler;
import java.util.Map;
import java.util.logging.Logger;

public class HeaderMechanismFactory implements HttpServerAuthenticationMechanismFactory {

    private static final Logger log = Logger.getLogger(HeaderMechanismFactory.class.getName());
    /*
     * This example uses service loader discovery to locate the factory, if a Provider was used instead visibility could be
     * reduced to be only accessible by the provider.
     */

    static final String CUSTOM_NAME = "CUSTOM_MECHANISM";

    public HttpServerAuthenticationMechanism createAuthenticationMechanism(String name, Map<String, ?> properties, CallbackHandler handler) throws HttpAuthenticationException {
        log.config("Entry HeaderMechanismFactory : createAuthenticationMechanism");
        if (CUSTOM_NAME.equals(name)) {
            /*
             * The properties could be used at this point to further customise the behaviour of the mechanism.
             */
            return new HeaderAuthenticationMechanism(handler);
        }

        return null;
    }

    public String[] getMechanismNames(Map<String, ?> properties) {
        log.config("Entry HeaderMechanismFactory : getMechanismNames");
        /*
         * At this stage the properties could be queried to only return a mechanism if compatible with the properties provided.
         */
        return new String[] { CUSTOM_NAME };
    }

}
