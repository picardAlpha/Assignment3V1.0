//Added by Ariel 04/01/23
package bgu.spl.net.impl.stomp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
public class ServerOutgoingFrame {

    enum Command {
        CONNECTED, //after receiving connect frame from a client, the server response with either this frame or an error
        MESSAGE, //message from a subscription to a client
        RECEIPT, //Contains a single header : receipt-id, which is a number generated by the client.
                // EVERY FRAME FROM A CLIENT WHICH HAS RECEIPT HEADER SHOULD BE ANSWERED WITH A RECEIPT FROM THE SERVER.
        ERROR

    }

//FIELDS

    Command frameCommand;

     List<Map<String,String>> headers = new LinkedList<>();
     private StringBuilder frame = new StringBuilder(); // the whole frame
     String[] lines; //each line examined separately
     String data; //input data from the user
     int counter = 0; //indicate which index is lines[] first non-empty line
     Long receiptId;
     //Initial Constructor


    //CONSTRUCTOR
     public ServerOutgoingFrame(Command command, List<Map<String,String>> headers, Long receipt ){ //we only get the data from client/server


        switch (command) {

            case CONNECTED:
                frame.append(command.toString()).append("\n");
                frame.append("version:").append(StompServer.VERSION).append("\n");
                frame.append("\0");
                break;

            case RECEIPT:
                frame.append(Command.RECEIPT.toString()).append("\n");
                if(receipt!=null)
                    frame.append("receipt-id:").append(receipt).append("\n");
                else
                    throw new IllegalArgumentException("Receipt frames must contain ID");
                frame.append("\0");
                break;

            case ERROR://NOT MANDATORY. mandatory in some cases.
                frame.append(Command.ERROR.toString()).append("\n");
                frame.append(headers.get(0));
                break;
            default :
                throw new IllegalArgumentException("Unknown Frame layout.");



        }



        }

//
//    public void linesSep(){ //seperate lines
//       lines = data.split("\n");
//    }
//    public void skipEmptyLines(){
//        while(counter<lines.length && lines[counter].isEmpty()) // while lines is empty, move to next line
//            counter++;
//    }
//     void identifyCommand(){ //what instance of frame will it be
//         command = FrameCommand.findCommand(lines[counter]);
//         counter++;
//
//     }
//
//     void identifyHeaders(){ //extract headers from data
//        while(!lines[counter].isEmpty()){
//            String[] val = lines[counter].split(":"); //
//            headers.put(val[0], val[1]);
//            counter++;
//
//        }}
//        void buildBody(){
//            for(int i = counter ; i < lines.length ; i++)
//                body.append(lines[counter]);
//        }
//        void buildFrame(){
//            frame.append(command);
//        frame.append('\n');
//        // Headers
//        for (String k : headers.keySet()) {
//            frame.append(k);
//            frame.append(':');
//            frame.append(headers.get(k));
//            frame.append('\n');
//        }
//        frame.append('\n');
//        // Body
//        if (body != null) {
//            frame.append(body);
//        }
//        }
//        public void build(){
//            linesSep();
//            skipEmptyLines();
//            identifyCommand();
//            buildBody();
//            buildFrame();
//        }
//
        @Override
        public String toString(){
         return frame.toString();
        }

        }
//
//
//
