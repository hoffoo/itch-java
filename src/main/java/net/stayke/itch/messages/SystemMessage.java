package net.stayke.itch.messages;

import net.stayke.itch.abstr.ItchMessage;

/**
 * Created by marin on 7/16/14
 *
 *
 */
public class SystemMessage extends ItchMessage {

    public final static char IDENT = 'S';

    public final Event event;

    public SystemMessage(byte[] data) {
        super(data, IDENT);
        this.event = Event.get(data[7]);
    }

    @Override
    public String toString() {
        return event.toString();
    }

    public enum Event {
        START_OF_MESSAGES     ('O'),
        START_OF_SYSTEM_HOURS ('S'),
        START_OF_MARKET_HOURS ('Q'),
        END_OF_MARKET_HOURS   ('M'),
        END_OF_SYSTEM_HOURS   ('E'),
        END_OF_MESSAGES       ('C');

        private final char ident;
        Event(char ident) {
            this.ident = ident;
        }

        public static Event get(byte b) {
            for (Event ev: Event.values()) {
                if (ev.ident == (char)b) {
                    return ev;
                }
            }
            return null;
        }
    }
}
