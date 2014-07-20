package net.stayke.itch.abstr;

/**
 * Created by marin on 7/16/14
 *
 * A source has to know how to read ITCH4.1
 *
 * This means that it must keep tracking of where it is in the stream, and
 * how long the message its delivering is. Buffering and cleanup are handled
 * here as well.
 *
 */
public interface ItchSource {
    // Get next message from source
    public abstract byte[] next();
}
