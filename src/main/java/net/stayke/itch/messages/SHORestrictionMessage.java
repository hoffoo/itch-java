package net.stayke.itch.messages;

import java.nio.ByteBuffer;

/**
 * Created by marin on 7/24/14
 *
 * SHORestrictionMessage: Section 4.3.3
 */
public class SHORestrictionMessage extends ItchMessage {

    public final static char IDENT = 'Y';

    public final String stock;
    public final SHOAction sho;

    public SHORestrictionMessage(byte[] data) {
        super(data, IDENT);
        ByteBuffer buf = ByteBuffer.wrap(data);
        this.stock = MessageUtils.AsString(buf, 5, 13);
        this.sho = SHOAction.get(MessageUtils.AsChar(buf, 13));
    }

    @Override
    public String toString() {
        return "SHO:" + stock + " " + sho;
    }

    public enum SHOAction {
        NO_PRICE_TEST          ('0'),
        PRICE_DROP_IN_SECURITY ('1'),
        PRICE_TEST_REMAINS     ('2');

        private final char action;
        SHOAction(char i) {
            this.action = i;
        }

        public static SHOAction get(char i) {
            for (SHOAction a: SHOAction.values()) {
                if (a.action == i) {
                    return a;
                }
            }
            return null;
        }
    }
}
