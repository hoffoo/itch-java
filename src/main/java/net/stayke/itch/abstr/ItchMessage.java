package net.stayke.itch.abstr;

import net.stayke.itch.messages.SystemMessage;
import net.stayke.itch.messages.Timestamp;

/**
 * Created by marin on 7/16/14
 *
 *
 */
public class ItchMessage {

    public final byte[] data;
    public final Timestamp timestamp;
    public char IDENT;

    public ItchMessage(byte[] data, char ident) {
        this.data = data;
        IDENT = ident;
        this.timestamp = new Timestamp(data);
    }

    public SystemMessage SystemMessage() {
        return new SystemMessage(data);
    }
}
