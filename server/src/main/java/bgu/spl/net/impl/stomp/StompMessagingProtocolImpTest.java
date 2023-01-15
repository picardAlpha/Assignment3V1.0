package bgu.spl.net.impl.stomp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StompMessagingProtocolImpTest {
    @Test

    public void processTest(){
        StompMessagingProtocolImp protocol = new StompMessagingProtocolImp();
        protocol.process("CONNECT\n" + "header1:action1\n");
    }

}