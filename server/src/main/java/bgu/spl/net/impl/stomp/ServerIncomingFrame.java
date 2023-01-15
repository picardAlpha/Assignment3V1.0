package bgu.spl.net.impl.stomp;


import org.apache.commons.lang3.tuple.MutablePair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ServerIncomingFrame {

    enum Command {
        CONNECT, // has exactly 4 header:
                // 1. accept-version:
                // 2. host:
                // 3. login:
                // 4. password
                // Must respond with a connected or an error frame.

        SEND,  // sends a message to a destination.
                //1 header : destination
                //if cant process this frame, we must return an error message to the client!
                // if the sender is not subscribed to a topic, it cant send messages to it !
        SUBSCRIBE, // TWO HEADERS : 1.destination
                                 // 2. id - received from the client, and used to unsubscribe. any MESSAGE frame sent from this server to the client MUST contain an id header!
                                 // this id must be generated uniquely in the client.

        DISCONNECT, //MUST RETURN RECEIPT
        UNSUBSCRIBE

    }



    Command command;
    List<MutablePair<String,String>> headers = new LinkedList<>();

    String[] frameLines;

    String frameBody = "";



    public ServerIncomingFrame(String frameString) {
        this.frameLines = frameString.split("\n");
        identifyCommand(frameLines[0]);


    }



    private void identifyCommand(String firstLine){
        identifyHeaders(frameLines);
        identifyBody(frameLines);

        switch(firstLine){

            case "CONNECT":
//                if(!frameBody.equals("") || headers.size()!= 4)
//                    System.out.println("TODO : ERROR SHOULD'VE BEEN RETURNED HERE"); // TODO : implement error returned either via exception that will be caught by connection handler or directly from here

                command = Command.CONNECT;

                break;

            case "SUBSCRIBE":
                command = Command.SUBSCRIBE;
                break;

            case "UNSUBSCRIBE":
                command = Command.UNSUBSCRIBE;
                break;
            case "SEND":
                command = Command.SEND;
                break;
            case "DISCONNECT":
                command = Command.DISCONNECT;
                break;

            default:
                throw new IllegalArgumentException("Unknown frame command.");
        }

    }


    void identifyHeaders(String[] frameLines){ // remove static after testing is done.
        for(int i=1; i< frameLines.length && frameLines[i].contains(":"); i++){
            String[] headerAndValue = frameLines[i].split(":",2); //splits the line only on the first occurrence of ":"
            headers.add(new MutablePair<>(headerAndValue[0],headerAndValue[1]));

        }
    }

    void identifyBody(String[] frameLines){
        for(int i=headers.size()+1 ; i< frameLines.length && !frameLines[i].contains("\0"); i++){
            frameBody = frameBody + frameLines[i];

        }
    }





}
