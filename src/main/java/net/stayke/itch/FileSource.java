package net.stayke.itch;

import net.stayke.itch.abstr.ItchSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * Created by marin on 7/16/14
 *
 *
 */
public class FileSource implements ItchSource {

    private File source;
    private byte[] buffer;
    private int pos;

    FileSource(File source) {

        this.source = source;
    }

    @Override
    public byte[] read(int count) {

        if (pos >= buffer.length) {
            return new byte[0];
        }

        int end = pos + count;
        if (end > buffer.length) {
            end = buffer.length;
        }

        pos += end;

        return Arrays.copyOfRange(buffer, pos - end, end);
    }

    // XXX remove
    // Utility method to read whole file into buffer.
    public void bufferFile(String path) throws IOException {

        File f = new File(path);
        if (!f.exists() || !f.isFile()) {
            throw new IOException("Bad path: " + path);
        }

        Files.readAllBytes(f.toPath());
    }

}
