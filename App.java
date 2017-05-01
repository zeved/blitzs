package org.zvd;

import org.java_websocket.drafts.Draft_17;

import java.net.InetSocketAddress;
import java.net.URI;

public class App {
    public static void main(String[] args) throws Exception {
        Server server = new Server(new InetSocketAddress("127.0.0.1", 2904));
        server.start();
        Sniffer sniffer = new Sniffer(new URI("ws://ws.blitzortung.org:8082"), new Draft_17(), server);
        try {
            sniffer.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
