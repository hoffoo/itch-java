package net.stayke.itch;

import net.stayke.itch.abstr.ItchSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by marin on 7/21/14
 *
 *
 */
public class NIOSource implements ItchSource {

    private FileChannel in;
    private ByteBuffer buf;

    public NIOSource(File f) throws FileNotFoundException {
        in = new FileInputStream(f).getChannel();
    }

    @Override
    public byte[] next() {
        return new byte[0];
    }
}
