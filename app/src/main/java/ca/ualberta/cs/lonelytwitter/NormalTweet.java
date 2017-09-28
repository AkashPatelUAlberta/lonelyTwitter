package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This is a class represents a Normal Tweet
 *
 * @author team x
 * @version 1.0
 * @see Tweet
 * @since 1.0
 */

public class NormalTweet extends Tweet {
    public NormalTweet(String message) {
        super(message);
    }

    /**
     * This is a NormalTweet constructor
     *
     * @param message   normal tweet message
     * @param date      normal tweet date
     */
    public NormalTweet(String message, Date date) {
        super(message, date);
    }

    /**
     * This boolean will return FALSE because this tweet
     * is not to be flagged as important
     *
     * @return
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
