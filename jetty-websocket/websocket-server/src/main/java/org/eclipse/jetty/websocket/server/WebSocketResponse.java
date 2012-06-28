package org.eclipse.jetty.websocket.server;

import java.io.IOException;
import java.util.List;

import org.eclipse.jetty.websocket.api.ExtensionConfig;

public interface WebSocketResponse
{
    /**
     * Get the accepted WebSocket protocol.
     * 
     * @return the accepted WebSocket protocol.
     */
    public String getAcceptedSubProtocol();

    /**
     * Get the list of extensions that should be used for the websocket.
     * 
     * @return the list of negotiated extensions to use.
     */
    public List<ExtensionConfig> getExtensions();

    /**
     * Issue a forbidden upgrade response.
     * <p>
     * This means that the websocket endpoint was valid, but the conditions to use a WebSocket resulted in a forbidden access.
     * <p>
     * Use this when the origin or authentication is invalid.
     * 
     * @param message
     *            the short 1 line detail message about the forbidden response
     * @throws IOException
     */
    public void sendForbidden(String message) throws IOException;

    /**
     * Set the accepted WebSocket Protocol.
     * 
     * @param protocol
     *            the protocol to list as accepted
     */
    public void setAcceptedSubProtocol(String protocol);

    /**
     * Set the list of extensions that are approved for use with this websocket.
     * <p>
     * This is Advanced usage of the {@link WebSocketCreator} to allow for a custom set of negotiated extensions.
     * <p>
     * Notes:
     * <ul>
     * <li>Per the spec you cannot add extensions that have not been seen in the {@link WebSocketRequest}, just remove entries you don't want to use</li>
     * <li>If this is unused, or a null is passed, then the list negotiation will follow default behavior and use the complete list of extensions that are
     * available in this WebSocket server implementation.</li>
     * </ul>
     * 
     * @param extensions
     *            the list of extensions to use.
     */
    public void setExtensions(List<ExtensionConfig> extensions);
}