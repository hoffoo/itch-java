package net.stayke.itch;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by marin on 7/21/14
 *
 *
 */
public class NIOSourceTest {

    String filename = "test_data";
    NIOSource source = null;

    @Before
    public void setUp() {
        try {
            source = new NIOSource(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Couldn't open file: " + filename);
        }
    }

    @Test
    public void OFF_testReadNIO() {

    }
}
