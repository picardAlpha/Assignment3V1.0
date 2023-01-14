package bgu.spl.net.impl.stomp;

import bgu.spl.net.srv.Connections;

public class StompConnections implements Connections<String> {
    @Override
    public boolean send(int connectionId, String msg) {

        //TODO : implement

        return false;
    }

    @Override
    public void send(String channel, String msg) {


        //TODO: implement
    }

    @Override
    public void disconnect(int connectionId) {

        // TODO : implement

    }
}
