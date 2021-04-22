// -----------------------------------------------------
// Part: 2A
// Written by: Chloe Hei Yu Law - 40173275
// -----------------------------------------------------

package Show;

/**
 * Create an interface named Watchable which has a method string isOnSameTime (Show S) where S is an
 * object of type TVShow described in the next part.
 */
public interface Watchable {
    /**
     * is on same time
     * @param s object
     * @return if on same time
     */
    public String isOnSameTime(TVShow s);
}
