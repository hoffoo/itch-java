package net.stayke.itch;

import net.stayke.itch.abstr.ItchSource;
import net.stayke.itch.abstr.ItchMessage;

import java.nio.ByteBuffer;

/**
 * Created by marin on 7/16/14
 *
 */
public class ItchParser {

    private ItchSource source;

    public ItchParser(ItchSource source) {
        this.source = source;
    }

    public ItchMessage next() {

        byte[] data = source.next();
        return unwrap(data);
    }

    // Unwrap one
    public ItchMessage unwrap(byte[] bytes) {

        // test that bytes length is the same as the msg length
        // otherwise our source is failing it up

        short len = getItchLen(bytes);
        if (len + 2 != bytes.length) {
            throw new RuntimeException("bad length, source is not giving us proper message: " + bytes.length);
        }

        char ident = (char) bytes[2];

        return new ItchMessage(bytes, ident);
    }

    private static short getItchLen(byte[] bytes) {

        byte[] byteLen = {bytes[0], bytes[1]};
        short len = ByteBuffer.wrap(byteLen).getShort();

        return len;
    }

}
