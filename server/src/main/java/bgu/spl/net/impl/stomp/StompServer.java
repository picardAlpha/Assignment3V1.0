package bgu.spl.net.impl.stomp;

import bgu.spl.net.api.MessageEncoderDecoder;

import bgu.spl.net.api.MessagingProtocol;
import bgu.spl.net.api.StompMessagingProtocol;
import bgu.spl.net.impl.echo.EchoProtocol;
import bgu.spl.net.impl.echo.LineMessageEncoderDecoder;
import bgu.spl.net.srv.BaseServer;
import bgu.spl.net.srv.Connections;
import bgu.spl.net.srv.Reactor;
import bgu.spl.net.srv.Server;

public class StompServer {
    public static final double VERSION = 1.2;


    public static void main(String[] args) {



        // TODO: implement this
        try {
            Reactor<String> server = new Reactor<String>(
                    3,
                    6234,
                    () -> new StompMessagingProtocolImp() ,
                    () -> new StompEncoderDecoderImp()
            );
            server.serve();
        }catch(Exception e){
            System.out.println("server initialization failed.");
            e.printStackTrace();
        }


        Server.threadPerClient(
                2353,
                () -> new EchoProtocol(),
                () -> new LineMessageEncoderDecoder()
        ).serve();

    }
}
