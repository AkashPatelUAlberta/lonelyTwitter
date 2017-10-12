package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by apate on 2017-10-11.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
//        testHasTweet();
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding a tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
        try {
            tweets.add(tweet);
            assertTrue(Boolean.FALSE);
        } catch (IllegalArgumentException e) {

        }

    }

    public void testDelete() {
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");
        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    public void testGetTweet() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        Tweet returnedTweet = list.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
    }

    public void testGetTweets() {
        TweetList list = new TweetList();
        Tweet first = new NormalTweet("first", new Date(1000));
        Tweet second = new NormalTweet("second", new Date(5000));
        Tweet third = new NormalTweet("third", new Date(7000));

        list.add(second); list.add(first); list.add(third);

        ArrayList<Tweet> newList = list.getTweets();
        assertEquals(newList.get(0), first);
        assertEquals(newList.get(1), second);
        assertEquals(newList.get(2), third);
    }

    public void testGetCount() {
        TweetList list = new TweetList();
        Tweet one = new NormalTweet("one");
        Tweet two = new NormalTweet("two");
        Tweet three = new NormalTweet("three");
        list.add(one); list.add(three); list.add(two);
        assertEquals(list.getCount(), 3);
    }

}
