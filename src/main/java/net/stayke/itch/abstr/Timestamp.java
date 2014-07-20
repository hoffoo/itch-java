package net.stayke.itch.abstr;

/**
 * Created by marin on 7/19/14
 *
 *
 */
public class Timestamp {

    public final byte[] nano;

    public Timestamp(byte[] data) {

        this.nano = new byte[]{
            data[1],
            data[2],
            data[3],
            data[4],
        };
    }
}
