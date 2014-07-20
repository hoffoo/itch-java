package net.stayke.itch.messages;

/**
 * Created by marin on 7/19/14
 *
 * TimeStampMessage: Section 4.1
 */
public class TimeStampMessage extends ItchMessage {

    final static char IDENT = 'T';

    public TimeStampMessage(byte[] data, char ident) {
        super(data, ident);
    }

    @Override
    public String toString() {
        //return event.toString();
        return super.toString();
    }
}
