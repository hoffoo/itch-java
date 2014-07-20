package net.stayke.itch.messages;

import java.nio.ByteBuffer;

/**
 * Created by marin on 7/19/14
 *
 * StockDirectoryMessage: Section 4.3.1
 */
public class StockDirectoryMessage extends ItchMessage {

    public final static char IDENT = 'R';

    public final Market market;
    public final String symbol;
    public final Compliance compliance;
    public final int lotSize;
    public final LotsType lotsType;

    public StockDirectoryMessage(byte[] data, char ident) {
        super(data, ident);
        this.market = Market.get((char)data[13]);
        this.symbol = getStockSymbol(data);
        this.compliance = Compliance.get((char)data[14]);
        this.lotSize = getLotSize(data);
        this.lotsType = LotsType.get((char)data[19]);
    }

    @Override
    public String toString() {
        return this.market + " - " + this.symbol + ": " + this.compliance + ", lots: " + this.lotSize;
    }

    public enum Market {
        NYSE                ('N'),
        NYSE_AMEX           ('A'),
        NYSE_ARCA           ('P'),
        NASDAQ_GLOBAL_SELECT('Q'),
        NASDAQ_GLOBAL       ('G'),
        NASDAQ_CAPITAL      ('S'),
        BATS_EXCHANGE       ('Z');

        private final char ident;
        Market(char ident) {
            this.ident = ident;
        }

        public static Market get(char e) {
            for (Market m: Market.values()) {
                if (m.ident == e) {
                    return m;
                }
            }
            return null;
        }
    }

    public enum Compliance {
        DEFICIENT ('D'),
        DELINQUENT ('E'),
        BANKRUPT ('Q'),
        SUSPENDED ('S'),
        DEFICIENT_BANKRUPT ('G'),
        DEFICIENT_DELINQUENT ('H'),
        DELINQUENT_BANKRUPT ('J'),
        DEFICIENT_DELINQUENT_BANKRUPT ('K'),
        COMPLIANT (' ');

        private final char ident;
        Compliance(char ident) {
            this.ident = ident;
        }

        public static Compliance get(char a) {
            for (Compliance c: Compliance.values()) {
                if (c.ident == a) {
                    return c;
                }
            }
            return null;
        }
    }

    public enum LotsType {
        MIXED ('N'),
        ROUND_ONLY ('Y');

        private final char ident;
        LotsType(char ident) {
            this.ident = ident;
        }

        public static LotsType get(char a) {
            for (LotsType c: LotsType.values()) {
                if (c.ident == a) {
                    return c;
                }
            }
            return null;
        }
    }

    private static String getStockSymbol(byte[] data) {
        char[] symbol = new char[8];

        // XXX skip loop
        for (int i = 0; i < 8; i++) {
            symbol[i] = (char)data[i + 5];
        }

        return new String(symbol);
    }

    public static int getLotSize(byte[] data) {
        byte[] byteLen = {data[15], data[16], data[17], data[18]};
        return ByteBuffer.wrap(byteLen).getInt();
    }
}
