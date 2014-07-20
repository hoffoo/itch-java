package net.stayke.itch;

import net.stayke.itch.abstr.ItchMessage;
import net.stayke.itch.messages.SystemMessage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class ItchTest {

    String filename = "test_data";
    FileSource source = null;

    @Before
    public void setUp() {
        source = new FileSource();
        try {
            source.bufferFile(filename);
        } catch (IOException e) {
            Assert.fail("Couldn't open file: " + filename);
        }
    }

    @Test
    public void testCompareSomeMessages() {

        ItchParser itch = new ItchParser(source);

        for (;;) {
            ItchMessage msg = itch.next();
            if (msg.IDENT == SystemMessage.IDENT) {
                System.out.println(msg.SystemMessage());
            }
        }
    }
}