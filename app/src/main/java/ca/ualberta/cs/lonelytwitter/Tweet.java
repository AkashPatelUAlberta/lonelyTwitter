/*
 * Tweet
 *
 * Version 1.0
 *
 * September 27, 2017
 *
 * Copyright (c) 2017 Team Akash, CMPUT301, University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behaviour at the University of Alberta. You can find a copy of the licence in this project. Otherwise please contact contact@abc.ca.
 */

package ca.ualberta.cs.lonelytwitter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Represents a Tweet.
 *
 * @author team x
 * @version 1.5
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0
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

    /**
     * Constructs a Tweet object
     *
     * @param message   tweet message
     * @param date      tweet date
     */
    public Tweet(String message, Date date) {
        this.date = date;
        this.message = message;
        this.moods = new ArrayList<CurrentMood>();
    }

    public String getMessage() {
        return message;
    }

    /**
     * Sets the tweet message
     *
     * @param message   tweet message
     * @throws TweetTooLongException
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() <= 140) {
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }
    }

    /**
     * Gets Tweet date
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets all the moods associated with this tweet
     *
     * @return
     */
    public String getMoods () {
        StringBuilder stringBuilder = new StringBuilder();
        for (CurrentMood mood: this.moods) {
            stringBuilder.append(mood.stringRepresentationOfMood() + "\n");
        }
        return stringBuilder.toString();
    }

    /**
     * Adds a mood to the tweet
     *
     * @param mood mood
     */
    public void addMood (CurrentMood mood) {
        this.moods.add(mood);
    }

    /**
     * Boolean is a flag if a tweet is important or normal.
     *
     * @return
     */
    public abstract Boolean isImportant();

    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }
}
