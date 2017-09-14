package ca.ualberta.cs.lonelytwitter;

/**
 * Created by apate on 2017-09-13.
 */

public class Happy extends CurrentMood {
    public String stringRepresentationOfMood() {
        return getDate().toString() + " Happy! :)";
    }
}
