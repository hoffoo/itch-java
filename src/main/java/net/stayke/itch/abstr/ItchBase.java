package net.stayke.itch.abstr;

import net.stayke.itch.message.ItchMessage;

import java.nio.ByteBuffer;

/**
 * Created by marin on 7/16/14
 *
 *
 */
public abstract class ItchBase {

    private ItchSource source;
    private ItchHandler parser;

    public ItchBase(ItchSource source, ItchHandler parser) {
        this.source = source;
        this.parser = parser;
    }

    public ItchMessage next() {
        byte[] data = source.next();
        return unwrap(data);
    }



    // Unwrap one
    public final ItchMessage unwrap(byte[] bytes) {

        // test that bytes length is the same as the msg length
        // otherwise our source is failing it up

        short len = getItchLen(bytes);
        if (len != bytes.length) {
            throw new RuntimeException("bad length, source is not giving us proper message: " + bytes.length);
        }

        return msg;
    }



    private final static short getItchLen(byte[] bytes) {

        byte[] byteLen = {bytes[0], bytes[1]};
        short len = ByteBuffer.wrap(byteLen).getShort();

        return len;
    }
}
