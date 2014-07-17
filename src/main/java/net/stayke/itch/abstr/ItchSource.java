package net.stayke.itch.abstr;

/**
 * Created by marin on 7/16/14
 *
 *
 */
public interface ItchSource {
    // Get next message from source
    public abstract byte[] next();
}
