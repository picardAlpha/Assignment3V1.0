//Added by Ariel 04/01/23
package bgu.spl.net.impl.stomp;

public enum FrameCommand {
    CONNECT("login"),
    CONNECTED("CONNECTED"),
    DISCONNECT("logout"),
    ERROR("ERROR"),
    MESSAGE("MESSAGE"),
    RECEIPT("RECEIPT"),
    SEND("report"),
    SUBSCRIBE("join"),
    UNSUBSCRIBE("exit");
    public String value;

    private FrameCommand(String value){
    this.value = value;
}
public String toString(){
    return this.value;
}
public static FrameCommand findCommand(String value){
    for(FrameCommand finder : FrameCommand.values()){
        if(finder.value.equals(value))
            return finder;
    }
    throw new IllegalArgumentException("command unknown");
}
}
   