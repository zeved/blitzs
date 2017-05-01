package org.zvd;

/**
 * Created by Zevedei Ionut <zeved.ionut@gmail.com> on 5/1/2017.
 */


import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Collection;

import org.java_websocket.WebSocket;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class Server extends WebSocketServer {
    private int port;
    private InetSocketAddress address;

    public Server(int port) throws UnknownHostException {
        super(new InetSocketAddress((port)));
        this.address = new InetSocketAddress(port);
        this.port = port;
    }

    public Server(InetSocketAddress address) {
        super(address);
        this.address = address;
        this.port = this.address.getPort();
    }

    @Override
    public void onOpen(WebSocket socket, ClientHandshake handshake) {
        //this.sendToAll("[i] connection: " + handshake.getResourceDescriptor());
        this.broadcast("welcome");
        System.out.println(socket.getRemoteSocketAddress().getAddress().getHostAddress() + " - connected");
    }

    @Override
    public void onClose(WebSocket socket, int code, String reason, boolean remote) {
        System.out.println(socket.getRemoteSocketAddress().getAddress().getHostAddress() + " - disconnected, reason: " + reason);
    }

    @Override
    public void onMessage(WebSocket socket, String message) {
        // interpret client messages here
    }

    @Override
    public void onFragment(WebSocket socket, Framedata fragment) {
        //
    }

    @Override
    public void onError(WebSocket socket, Exception e) {
        e.printStackTrace();
    }

    @Override
    public void onStart() {
        System.out.println("[+] server started on " + this.address.getAddress().getHostAddress() + ":" + this.port);
    }

    public void broadcast(String message) {
        Collection<WebSocket> sockets = connections();
        synchronized (sockets) {
            for (WebSocket socket : sockets)
                socket.send(message);
        }
    }
}
