package net.stayke.itch.messages;

/**
 * Created by marin on 7/16/14
 *
 * SystemMessage: Section 4.2
 */
public class SystemMessage extends ItchMessage {

    public final static char IDENT = 'S';
    public final Event event;

    public SystemMessage(byte[] data, char ident) {
        super(data, ident);
        this.event = Event.get((char)data[5]);
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
        END_OF_MESSAGES       ('C'),
        // EMC = EMERGENCY_MARKET_CONDITION
        EMC_HALT              ('A'),
        EMC_QUOTE_ONLY        ('R'),
        EMC_RESUMPTION        ('B');

        private final char ident;
        Event(char ident) {
            this.ident = ident;
        }

        public static Event get(char e) {
            for (Event ev: Event.values()) {
                if (ev.ident == e) {
                    return ev;
                }
            }
            return null;
        }
    }
}
