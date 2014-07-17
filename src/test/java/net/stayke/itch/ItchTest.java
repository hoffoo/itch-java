package net.stayke.itch;

import net.stayke.itch.message.ItchMessage;
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
        Itch itch = new Itch(source);

        ItchMessage msg = itch.next();
        Assert.assertEquals(msg.len, 12);
        Assert.assertEquals(msg.msgType, 'S');

        msg = itch.next();
        Assert.assertEquals(msg.len, 39);
        Assert.assertEquals(msg.msgType, 'R');
    }
}