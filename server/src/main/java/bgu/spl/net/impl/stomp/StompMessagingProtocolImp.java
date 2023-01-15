package bgu.spl.net.impl.stomp;

import bgu.spl.net.srv.Connections;

import java.time.LocalDateTime;

public class StompMessagingProtocolImp implements bgu.spl.net.api.MessagingProtocol<String> {

    boolean shouldTerminate = false;

    public void start(int connectionId, Connections<String> connections) {

    }

    @Override
    public String process(String message) {
//        shouldTerminate = "bye".equals(message);
//        System.out.println("[" + LocalDateTime.now() + "]: " + message);
//        return "[FRAME]";
        ServerIncomingFrame frame = new ServerIncomingFrame(message); // build frame
        switch (frame.command){

            case CONNECT:
                System.out.println("I got a connect frame");
                break;

        }

        return "";








        //TODO : implement - responses are sent using the connections object via its send method - send(sting channel, String msg)
    }

    @Override
    public boolean shouldTerminate() {
        return shouldTerminate;
    }
}
