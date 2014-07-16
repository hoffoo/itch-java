package net.stayke.itch.abstr;

/**
 * Created by marin on 7/16/14
 *
 *
 */
public interface ItchSource {

    // Get @count of bytes from source.
    byte[] read(int count);
}
