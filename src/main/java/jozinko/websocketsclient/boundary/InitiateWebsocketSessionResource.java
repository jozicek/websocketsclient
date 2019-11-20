package jozinko.websocketsclient.boundary;

import javax.inject.Inject;
import javax.websocket.DeploymentException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.IOException;
import java.net.URISyntaxException;

@Path("initiate")
public class InitiateWebsocketSessionResource {

    @Inject
    private WebSocketClient client;

    @GET
    public void initiateSession() throws DeploymentException, IOException, URISyntaxException {
        client.openSession();
    }

}
