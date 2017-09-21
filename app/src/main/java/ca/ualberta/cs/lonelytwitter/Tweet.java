package ca.ualberta.cs.lonelytwitter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by apate on 2017-09-13.
 */

public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;
    private ArrayList<CurrentMood> moods;

    public Tweet(String message) {
        date = new Date();
        this.message = message;
        this.moods = new ArrayList<CurrentMood>();
    }

    public Tweet(String message, Date date) {
        this.date = date;
        this.message = message;
        this.moods = new ArrayList<CurrentMood>();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() <= 140) {
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }
    }

    public Date getDate() {
        return date;
    }

    public String getMoods () {
        StringBuilder stringBuilder = new StringBuilder();
        for (CurrentMood mood: this.moods) {
            stringBuilder.append(mood.stringRepresentationOfMood() + "\n");
        }
        return stringBuilder.toString();
    }

    public void addMood (CurrentMood mood) {
        this.moods.add(mood);
    }

    public abstract Boolean isImportant();

    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }
}
