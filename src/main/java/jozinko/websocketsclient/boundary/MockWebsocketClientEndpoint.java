package jozinko.websocketsclient.boundary;

import jozinko.websocketsclient.entity.WebSocketMessage;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import java.io.IOException;
import java.nio.charset.Charset;

@ClientEndpoint(decoders = {WebSocketMessageDecoder.class})
public class MockWebsocketClientEndpoint {

    @OnMessage
    public void onMessage(final WebSocketMessage message, final Session session) throws IOException {
        System.out.println("CLIENT onMessage: " + message);
        session.getBasicRemote().sendBinary(Charset.forName("UTF-8").encode(message.toString()));
    }

}
