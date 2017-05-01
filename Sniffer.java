package org.zvd;

/**
 * Created by Zevedei Ionut <zeved.ionut@gmail.com> on 5/1/2017.
 */

import java.net.*;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.framing.Framedata;

public class Sniffer extends WebSocketClient {
    public Server server;

    public Sniffer(URI server, Draft draft, Server _server) {
        super(server, draft);
        this.server = _server;
    }

    public Sniffer(URI server, Server _server) {
        super(server);
        this.server = _server;
    }

    @Override
    public void onOpen(ServerHandshake handshake) {
        System.out.println("[i] connection opened, " + handshake.getHttpStatusMessage());
        this.send("{\"sig\":false}");
    }

    @Override
    public void onMessage(String message) {
        this.server.broadcast(message);
    }

    @Override
    public void onFragment(Framedata fragment) {
        System.out.println("[+] received fragment: " + new String(fragment.getPayloadData().array()));
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("[!] connection closed by " + (remote ? "remote peer" : "us"));
    }

    @Override
    public void onError(Exception e) {
        e.printStackTrace();
    }
}
