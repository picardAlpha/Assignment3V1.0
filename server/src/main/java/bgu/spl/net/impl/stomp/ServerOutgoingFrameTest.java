package bgu.spl.net.impl.stomp;

import org.junit.jupiter.api.Test;

class ServerOutgoingFrameTest {


    @Test
    public void frameBuildingTest() {

        System.out.println("-------------RECEIPT TEST-------------");
        ServerOutgoingFrame serverOutgoingFrame = new ServerOutgoingFrame(ServerOutgoingFrame.Command.RECEIPT, null, 14L);

        System.out.println(serverOutgoingFrame + "\n");

        System.out.println("-------------CONNECTED TEST-------------");
        serverOutgoingFrame = new ServerOutgoingFrame(ServerOutgoingFrame.Command.CONNECTED, null, null);
        System.out.println(serverOutgoingFrame);
    }

}