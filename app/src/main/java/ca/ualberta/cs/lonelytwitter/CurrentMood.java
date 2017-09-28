package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * This is a class represents the Current Mood
 *
 * @author team x
 * @version 1.0
 * @see Tweet
 * @since 1.0
 */

public abstract class CurrentMood {
    private Date date;

   public CurrentMood () {
       this(new Date());
   }

    /**
     * Constructs a mood
     *
     * @param date CurrentMood date
     */
   public CurrentMood (Date date) {
       this.date = date;
   }

    /**
     * Returns current mood date
     *
     * @return
     */
   public Date getDate() {
       return this.date;
   }

    /**
     * Set's the date of the CurrentMood
     *
     * @param date CurrentMood date
     */
   public void setDate(Date date) {
       this.date = date;
   }

    /**
     * String representation of mood
     *
     * @return
     */
   public abstract String stringRepresentationOfMood();

}
