package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by apate on 2017-09-13.
 */

public interface Tweetable {
    public String getMessage();
    public Date getDate();
    public void addMood(CurrentMood mood);
    public String getMoods();
}
