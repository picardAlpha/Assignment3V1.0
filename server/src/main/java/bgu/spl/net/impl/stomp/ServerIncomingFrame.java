package bgu.spl.net.impl.stomp;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ServerIncomingFrame {

    enum Command {
        CONNECT,
        SEND,  // sends a message to a destination.
                //1 header : destination
                //if cant process this frame, we must return an error message to the client!
                // if the sender is not subscribed to a topic, it cant send messages to it !
        SUBSCRIBE,
        DISCONNECT,
        UNSUBSCRIBE

    }

    Command command;
    List<Map<String, String>> headers = new LinkedList<>();

    String[] frame ;

    public ServerIncomingFrame(String frameString) {
        this.frame = frameString.split("\n");
        identifyCommand(frame[0]);
        identifyHeaders(frame);


    }



    private void identifyCommand(String firstLine){
        switch(firstLine){

            case "CONNECT":
                command = Command.CONNECT;
                break;

            case "SUBSCRIBE":
                command = Command.SUBSCRIBE;
                break;

            case "UNSUBSCRIBE":
                command= Command.UNSUBSCRIBE;
                break;
            case "MESSAGE":
                command= Command.MESSAGE;
                break;
            case "DISCONNECT":
                command= Command.DISCONNECT;
                break;

            default:
                throw new IllegalArgumentException("Unknown frame command.");
        }

    }


    private void identifyHeaders(String[] frame){



    }





}
