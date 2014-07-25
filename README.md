itch-java
=========

Java library for NASDAQ ITCH (SoupBinTCP) protocol

Summary
=======

This is an academic project, it attempts to clearly show ITCH 4.1 and SoupBin work.

Grab a data file from ftp://emi.nasdaq.com/ITCH/ and load it up as a FileSource to check it out. You will need one of the [datestamp].NASDAQ_ITCH41 files. The others are different protocol formats and probably will not work.

Example
=======

```java

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
        case MarketParticipantPositionMessage.IDENT:
            System.out.println(msg.toMarketParticipantPositionMessage());
            break;
        }
    }
```

License
=======

MIT
