package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by apate on 2017-10-11.
 */

public class TweetList {

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public TweetList(){}

    public void add(Tweet tweet) {
        if (tweets.contains(tweet)) {throw new IllegalArgumentException();}
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    public Tweet getTweet(int index) {
        return tweets.get(index);
    }

    public ArrayList<Tweet> getTweets() {
        ArrayList<Tweet> list = new ArrayList<Tweet>();
        list.addAll(tweets);

        Collections.sort(list, new Comparator<Tweet>() {
            public int compare(Tweet lhs, Tweet rhs) {
                return lhs.getDate().compareTo(rhs.getDate());
            }
        });
        return list;
    }

    public int getCount() {
        return tweets.size();
    }
}
