package bgu.spl.net.impl.stomp;

import bgu.spl.net.srv.ConnectionHandler;

import java.io.IOException;

public class StompConnectionHandler implements ConnectionHandler<String> {


    @Override
    public void send(String msg) {

        //TODO : Should use the send message in StompConnections.java

    }

    @Override
    public void close() throws IOException {

        //TODO : implement

    }
}
