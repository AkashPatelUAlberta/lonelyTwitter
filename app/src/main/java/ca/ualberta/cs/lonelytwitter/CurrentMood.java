package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by apate on 2017-09-13.
 */

public abstract class CurrentMood {
    private Date date;

   public CurrentMood () {
       this(new Date());
   }

   public CurrentMood (Date date) {
       this.date = date;
   }

   public Date getDate() {
       return this.date;
   }

   public void setDate(Date date) {
       this.date = date;
   }

   public abstract String stringRepresentationOfMood();

}
