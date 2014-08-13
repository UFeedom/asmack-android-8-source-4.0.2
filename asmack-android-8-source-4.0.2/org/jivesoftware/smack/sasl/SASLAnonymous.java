/**
 *
 * Copyright the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jivesoftware.smack.sasl;

import org.jivesoftware.smack.SASLAuthentication;
import org.jivesoftware.smack.SmackException.NotConnectedException;

import java.io.IOException;

import org.apache.harmony.javax.security.auth.callback.CallbackHandler;

/**
 * Implementation of the SASL ANONYMOUS mechanism
 *
 * @author Jay Kline
 */
public class SASLAnonymous extends SASLMechanism {

    public SASLAnonymous(SASLAuthentication saslAuthentication) {
        super(saslAuthentication);
    }

    protected String getName() {
        return "ANONYMOUS";
    }

    public void authenticate(String username, String host, CallbackHandler cbh) throws IOException, NotConnectedException {
        authenticate();
    }

    public void authenticate(String username, String host, String password) throws IOException, NotConnectedException {
        authenticate();
    }

    protected void authenticate() throws IOException, NotConnectedException {
        // Send the authentication to the server
        getSASLAuthentication().send(new AuthMechanism(getName(), null));
    }

    public void challengeReceived(String challenge) throws IOException, NotConnectedException {
        // Build the challenge response stanza encoding the response text
        // and send the authentication to the server
        getSASLAuthentication().send(new Response());
    }


}
