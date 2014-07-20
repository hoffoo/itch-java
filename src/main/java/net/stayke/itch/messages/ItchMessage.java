package net.stayke.itch.messages;

import net.stayke.itch.abstr.Timestamp;

/**
 * Created by marin on 7/16/14
 *
 * An ItchMessage is a generic ITCH4.1 Message: Section 4
 *
 * This class contains methods to convert to other messages types.
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

    /**
     * Returns true of message is of type TimestampMessage
     *
     * @see net.stayke.itch.messages.TimeStampMessage
     */
    public final boolean isTimeStampMessage() {
        return IDENT == TimeStampMessage.IDENT;
    }

    /**
     * Returns this message as a TimeStampMessage
     *
     * @see net.stayke.itch.messages.TimeStampMessage
     */
    public final TimeStampMessage toTimeStampMessage() {
        return new TimeStampMessage(data, IDENT);
    }

    /**
     * Returns true of message is of type SystemMessage
     *
     * @see net.stayke.itch.messages.SystemMessage
     */
    public final boolean isSystemMessage() {
        return IDENT == SystemMessage.IDENT;
    }

    /**
     * Returns this message as a SystemMessage
     *
     * @see net.stayke.itch.messages.SystemMessage
     */
    public final SystemMessage toSystemMessage() {
        return new SystemMessage(data, IDENT);
    }

    /**
     * Returns true of this message is a StockDirectoryMessage
     *
     * @see net.stayke.itch.messages.StockDirectoryMessage
     */
    public final boolean isStockDirectoryMessage() {
        return IDENT == StockDirectoryMessage.IDENT;
    }

    /**
     * Returns this message as a StockDirectoryMessage
     *
     * @see net.stayke.itch.messages.StockDirectoryMessage
     */
    public final StockDirectoryMessage toStockDirectoryMessage() {
        return new StockDirectoryMessage(data, IDENT);
    }


    public final StockTradingMessage toStockTradingMessage() {
        return new StockTradingMessage(data, IDENT);
    }
}
