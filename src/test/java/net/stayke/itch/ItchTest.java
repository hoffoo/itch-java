package net.stayke.itch;

import net.stayke.itch.messages.ItchMessage;
import net.stayke.itch.messages.StockDirectoryMessage;
import net.stayke.itch.messages.StockTradingMessage;
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
    public void testPrintSome() {

        ItchParser itch = new ItchParser(source);

        for (;;) {
            ItchMessage msg = itch.next();

            if (msg == null) {
                System.out.println("End of messages.");
                break;
            }

            switch(msg.IDENT) {
            case SystemMessage.IDENT:
                System.out.println(msg.toSystemMessage());
                break;
            case StockDirectoryMessage.IDENT:
                System.out.println(msg.toStockDirectoryMessage());
                break;
            case StockTradingMessage.IDENT:
                System.out.println(msg.toStockTradingMessage());
                break;
            }
        }
    }
}