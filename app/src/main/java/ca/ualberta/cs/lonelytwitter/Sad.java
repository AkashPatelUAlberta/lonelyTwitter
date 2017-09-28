package ca.ualberta.cs.lonelytwitter;

/**
 * This is a class for mood 'Sad'. It contains
 * the string representation of 'Sad'
 *
 * @author team x
 * @version 1.0
 * @see CurrentMood
 * @see Tweet
 * @since 1.0
 */
public class Sad extends CurrentMood {
    /**
     * Return the string representation of Sad
     *
     * @return
     */
    public String stringRepresentationOfMood() {
        return getDate().toString() + " Sad :(";
    }
}
