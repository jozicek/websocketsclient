package jozinko.websocketsclient.entity;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class WebSocketMessage {

    public String id;
    public String message;


    @Override
    public String toString() {
        final Jsonb jsonb = JsonbBuilder.create();
        return jsonb.toJson(this);
    }


}
