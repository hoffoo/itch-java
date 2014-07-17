package net.stayke.itch;

import net.stayke.itch.abstr.ItchBase;
import net.stayke.itch.abstr.ItchHandler;
import net.stayke.itch.abstr.ItchSource;

/**
 * Created by marin on 7/16/14
 *
 *
 */
public class Itch extends ItchBase {

    Itch(ItchSource source) {
        super(source, new ItchHandler());
    }

    Itch(ItchSource source, ItchHandler parser) {
        super(source, parser);
    }

}

