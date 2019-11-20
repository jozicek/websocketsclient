package jozinko.websocketsclient.boundary;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@ApplicationScoped
public class WebSocketClient {

    private static final String WS_SERVER_URL = "ws://localhost:8080/websocketadapter/websocket";
    private Session session;

    public Session openSession() throws URISyntaxException, IOException, DeploymentException {
        System.out.println("WebSocketClient: Connect to server and open the session");
        if (session != null && session.isOpen()) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).entity("websocket session is already opened").build());
        }
        final WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();
        this.session = webSocketContainer.connectToServer(MockWebsocketClientEndpoint.class, new URI(WS_SERVER_URL));
        return this.session;
    }


}
