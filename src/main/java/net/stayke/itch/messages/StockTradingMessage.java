package net.stayke.itch.messages;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * Created by marin on 7/19/14
 *
 * StockTradingMessage: Section 4.3.2
 */
public class StockTradingMessage extends ItchMessage {

    public final static char IDENT = 'H';

    public final String stock;
    public final State state;
    public final String reason;

    public StockTradingMessage(byte[] data) {
        super(data, IDENT);
        ByteBuffer buf = ByteBuffer.wrap(data);
        stock = MessageUtils.AsString(buf, 5, 12);
        state = State.get((char)data[13]);
        reason = MessageUtils.AsString(buf, 15, 18);
    }

    enum State {
        HALTED ('H'),
        PAUSED ('P'),
        QUOTE_ONLY ('Q'),
        TRADING ('T');

        private final char ident;
        State(char ident) {
            this.ident = ident;
        }

        public static State get(char e) {
            for (State m: State.values()) {
                if (m.ident == e) {
                    return m;
                }
            }
            return null;
        }
    }

    @Override
    public String toString() {
        return "TRADE: " + stock + ": " + state + ":" + reason;
    }
}
