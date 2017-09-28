package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * This is an interface for tweet
 *
 * @author team x
 * @version 1.0
 * @see Tweet
 * @see CurrentMood
 * @since 1.0
 */

public interface Tweetable {
    public String getMessage();
    public Date getDate();
    public void addMood(CurrentMood mood);
    public String getMoods();
}
