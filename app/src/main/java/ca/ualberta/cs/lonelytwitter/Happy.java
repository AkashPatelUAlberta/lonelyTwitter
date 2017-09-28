package ca.ualberta.cs.lonelytwitter;

/**
 * This is a class for mood 'Happy'. It contains
 * the string representation of 'Happy'
 *
 * @author team x
 * @version 1.0
 * @see CurrentMood
 * @see Tweet
 * @since 1.0
 */

public class Happy extends CurrentMood {
    /**
     * Returns string representation of Happy
     *
     * @return
     */
    public String stringRepresentationOfMood() {
        return getDate().toString() + " Happy! :)";
    }
}
