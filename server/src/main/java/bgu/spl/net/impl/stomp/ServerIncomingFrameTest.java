package bgu.spl.net.impl.stomp;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServerIncomingFrameTest {


    @Test
    public void incomingFrameTest(){

        StringBuilder testFrameString = new StringBuilder();

        testFrameString.append("CONNECT\n");
        testFrameString.append("header1:test1\n");
        testFrameString.append("header2:test2\n");
        testFrameString.append("\n");
        testFrameString.append("blabla\n ");
        testFrameString.append("another blabla\n");
        testFrameString.append("\0");

        ServerIncomingFrame testFrame = new ServerIncomingFrame(testFrameString.toString());
        System.out.println("The command is : " + testFrame.command.toString());
        System.out.println("The headers are : " + testFrame.headers);
        System.out.println("The body is : " + testFrame.frameBody);


    }

    @Test
    public void splitHeadersTest(){

        StringBuilder testFrame = new StringBuilder();

        testFrame.append("CONNECT\n");
        testFrame.append("header1:test1\n");
        testFrame.append("header2:test2\n");
        testFrame.append("\n");
        testFrame.append("blabla");

        ServerIncomingFrame frame = new ServerIncomingFrame(testFrame.toString());

        System.out.println(frame.headers);






    }



}