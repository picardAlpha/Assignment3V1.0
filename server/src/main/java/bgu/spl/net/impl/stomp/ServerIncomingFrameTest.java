package bgu.spl.net.impl.stomp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServerIncomingFrameTest {


    @Test
    public void incomingFrameTest(){

        ServerIncomingFrame frame = new ServerIncomingFrame("CONNECT"+ "\n");
        System.out.println(frame);


    }



}