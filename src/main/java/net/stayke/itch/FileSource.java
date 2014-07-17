package net.stayke.itch;

import net.stayke.itch.message.ItchMessage;
import net.stayke.itch.abstr.ItchSource;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * Created by marin on 7/16/14
 *
 *
 */
public class FileSource extends ItchSource {

    private byte[] buffer;
    private int offset = 0;

    @Override
    public byte[] next() {

        if (offset == 0) {
            return firstMessage();
        }

        if (offset >= buffer.length) {
            return null;
        }

        byte[] byteLen = {buffer[offset], buffer[offset+1]};
        short len = ByteBuffer.wrap(byteLen).getShort();

        byte[] msg = Arrays.copyOfRange(buffer, offset, offset + len);

        offset += len + 2;

        return msg;
    }

    // Used to read the first message from a source, when we don't know
    // a length or start byte.
    private byte[] firstMessage() {
        byte[] byteLen = {buffer[0], buffer[1]};

        short len = ByteBuffer.wrap(byteLen).getShort();

        // XXX catch bad file
        byte[] msg = Arrays.copyOfRange(buffer, 0, len);

        offset += len + 2;

        return msg;
    }

    // XXX remove
    // Utility method to read whole file into buffer.
    public void bufferFile(String path) throws IOException {

        File f = new File(path);
        if (!f.exists() || !f.isFile()) {
            throw new IOException("Bad path: " + path);
        }

        buffer = Files.readAllBytes(f.toPath());
    }
}
