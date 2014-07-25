package net.stayke.itch.messages;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * Created by marin on 7/19/14
 *
 *
 */
abstract class MessageUtils {

    public static String AsString(ByteBuffer buf, int start, int end) {

        buf.position(start);
        buf.limit(end);

        String str =  Charset.forName("ISO-8859-1").decode(buf).toString();
        undo(buf);

        return str;
    }

    public static int AsInt(ByteBuffer buf, int at) {
        return (int)buf.get(at);
    }

    public static char AsChar(ByteBuffer buf, int at) {
        return (char)buf.get(at);
    }

    private static void undo(ByteBuffer buf) {
        buf.limit(buf.capacity());
        buf.rewind();
    }

}
