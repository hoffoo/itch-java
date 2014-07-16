package net.stayke.itch.abstr;

/**
 * Created by marin on 7/16/14
 *
 *
 */
public abstract class ItchBase<ItchSource, ItchMessageParser> {
    public ItchSource source;
    public ItchMessageParser parser;
}
