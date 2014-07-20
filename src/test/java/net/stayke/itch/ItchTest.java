package net.stayke.itch;

import net.stayke.itch.messages.ItchMessage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

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
            if (msg == null) {
                System.out.println("End of messages.");
                break;
            }
            if (msg.isSystemMessage()) {
                System.out.println(msg.toSystemMessage());
            }

            if (msg.isStockDirectoryMessage()) {
                System.out.println(msg.toStockDirectoryMessage());
            }
        }
    }
}