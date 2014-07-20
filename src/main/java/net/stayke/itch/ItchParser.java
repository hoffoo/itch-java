package net.stayke.itch;

import net.stayke.itch.abstr.ItchSource;
import net.stayke.itch.messages.ItchMessage;

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

        if (bytes == null) {
            return null;
        }

        char ident = (char) bytes[0];
        return new ItchMessage(bytes, ident);
    }
}
