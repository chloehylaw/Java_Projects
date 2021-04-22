// -----------------------------------------------------
// Part: 2B
// Written by: Chloe Hei Yu Law - 40173275
// -----------------------------------------------------
package Show;
import java.util.Scanner;

/**
 * It is assumed that show name is always recorded as a single word
 *  It is also assumed that no two TV shows can have the exact same showID
 */
public class TVShow implements Watchable{
    /**
     * string show ID
     */
    public String showID;
    /**
     * string show name
     */
    public String showName;
    /**
     * double show start time
     */
    public double startTime;
    /**
     * double show end time
     */
    public double endTime;

    /**
     * get ShowID
     * @return showID
     */
    public String getShowID() {
        return showID;
    }

    /**
     * set ShowID
     * @param showID showID
     */
    public void setShowID(String showID) {
        this.showID = showID;
    }

    /**
     * get ShowName
     * @return showName
     */
    public String getShowName() {
        return showName;
    }

    /**
     * set ShowName
     * @param showName show name
     */
    public void setShowName(String showName) {
        this.showName = showName;
    }

    /**
     * get StartTime
     * @return startTime
     */
    public double getStartTime() {
        return startTime;
    }

    /**
     * set StartTime
     * @param startTime start Time
     */
    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    /**
     * get endTime
     * @return endTime
     */
    public double getEndTime() {
        return endTime;
    }

    /**
     * set endTime
     * @param endTime end Time
     */
    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    /**
     * Parameterized constructor
     * @param showID show id
     * @param showName  show name
     * @param startTime  start time
     * @param endTime  end time
     */
    public TVShow(String showID, String showName, double startTime, double endTime){
        this.showID = showID;
        this.showName = showName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Copy constructor
     * @param s object
     * @param value  this value will correspond to the unique showID rule
     */
    public TVShow(TVShow s, String value){
        this.showID = value;
        this.showName = s.getShowName();
        this.startTime = s.getStartTime();
        this.endTime = s.getEndTime();
    }

    /**
     * clone() method
     * @param sc prompt the user to enter a new showID
     * @return a clone of the calling object with the exception of the showID, which is assigned the value entered by the user
     */
    public TVShow clone(Scanner sc){
        System.out.print("Enter a TVShow ID to clone: ");
        return new TVShow(this, sc.next());
    }

    /**
     * toString() method
     * @return show information
     */
    public String toString() {
        return "\tShow ID = " + showID + "\n\tShow Name: " + showName +
                "\n\tStart Time: " + startTime + "\n\tEnd Time: " + endTime + "\n";
    }

    /**
     * equals() method
     * Two shows are equal if they have the same attributes,
     * with the exception of the showID, which could be different
     * @param otherShow object equals to
     * @return true if equal, else, false
     */
    public boolean equals(TVShow otherShow){
        if(otherShow == null || this.getClass() != otherShow.getClass()){
            return false;
        }else{
            return(this.showName.equals(((TVShow) otherShow).showName) &&
                    this.startTime == ((TVShow) otherShow).startTime &&
                    this.endTime == ((TVShow) otherShow).endTime);
        }
    }

    /**
     * Determines if the shows are at different times, overlap or at the same time
     * @param s object
     * @return Same time, Different time, or Some Overlap
     */
    public String isOnSameTime(TVShow s) {
        if(this.startTime == s.startTime && this.endTime == s.endTime){
            return "Same time";
        }else if (this.startTime < s.startTime && s.startTime < this.endTime
                || this.startTime > s.startTime && s.endTime > this.startTime){
            return "Some overlap";
        }else{
            return "Different time";
        }
    }

}
