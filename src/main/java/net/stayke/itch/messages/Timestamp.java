package net.stayke.itch.messages;

/**
 * Created by marin on 7/19/14
 *
 *
 */
public class Timestamp {

    public final byte[] nano;

    public Timestamp(byte[] data) {

        this.nano = new byte[]{
            data[3],
            data[4],
            data[5],
            data[6],
        };
    }
}
