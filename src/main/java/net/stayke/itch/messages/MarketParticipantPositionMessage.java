package net.stayke.itch.messages;

import java.nio.ByteBuffer;

/**
 * Created by marin on 7/24/14
 *
 *
 */
public class MarketParticipantPositionMessage extends ItchMessage {

    public static final char IDENT = 'L';

    public final String mpid;
    public final String stock;
    public final PrimaryMarketMarker marker;
    public final MarketMarkerMode mode;
    public final MarketParticipantState state;

    public MarketParticipantPositionMessage(byte[] data) {
        super(data, IDENT);
        ByteBuffer buf = ByteBuffer.wrap(data);
        this.mpid = MessageUtils.AsString(buf, 5, 9);
        this.stock = MessageUtils.AsString(buf, 9, 17);
        this.marker = PrimaryMarketMarker.get(MessageUtils.AsChar(buf, 17));
        this.mode = MarketMarkerMode.get(MessageUtils.AsChar(buf, 18));
        this.state = MarketParticipantState.get(MessageUtils.AsChar(buf, 19));
    }

    @Override
    public String toString() {
        return "PARTICIPATION MESSAGE: " + stock + " " + mpid + " " + marker + " " + mode + " " + state;
    }

    public enum PrimaryMarketMarker {
        YES ('Y'),
        NO  ('N');

        private final char ident;
        PrimaryMarketMarker(char c) {
            this.ident = c;
        }

        public static PrimaryMarketMarker get(char c) {
            for (PrimaryMarketMarker m: PrimaryMarketMarker.values()) {
                if (m.ident == c) {
                    return m;
                }
            }
            return null;
        }
    }

    public enum MarketMarkerMode {
        NORMAL        ('N'),
        PASSIVE       ('P'),
        SYNDICATE     ('S'),
        PRE_SYNDICATE ('P'),
        PENALTY       ('L');

        private final char ident;
        MarketMarkerMode(char c) {
            this.ident = c;
        }

        public static MarketMarkerMode get(char c) {
            for (MarketMarkerMode m: MarketMarkerMode.values()) {
                if (m.ident == c) {
                    return m;
                }
            }
            return null;
        }
    }

    public enum MarketParticipantState {
        ACTIVE        ('A'),
        EXCUSED       ('E'),
        WITHDRAWN     ('W'),
        SUSPENDED     ('S'),
        DELETED       ('D');

        private final char ident;
        MarketParticipantState(char c) {
            this.ident = c;
        }

        public static MarketParticipantState get(char c) {
            for (MarketParticipantState m: MarketParticipantState.values()) {
                if (m.ident == c) {
                    return m;
                }
            }
            return null;
        }
    }
}
