package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This is a class represents an Important Tweet
 *
 * @author team x
 * @version 1.0
 * @see Tweet
 * @since 1.0
 */

public class ImportantTweet extends Tweet {
    public ImportantTweet (String message) {
        super(message);
    }

    /**
     * This is the contructor for an important tweet
     *
     * @param message   important tweet message
     * @param date      important tweet date
     */
    public ImportantTweet(String message, Date date) {
        super(message, date);
    }

    /**
     * Because this tweet is important this boolean will
     * be equated to TRUE
     *
     * @return
     */
    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
