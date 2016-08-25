
package p1;

/**
 *
 * @author cxs0290
 */

/**
 * A Flatland bug knows its location (X and Y values), can be confined to a range
 * (min and max X and Y values), can be alive or dead and has a gender 
 * (male or female).  Additionally, a bug may move to an adjoining space in
 * one of 8 possible directions, but only within its range or stay in its
 * current location. As Flatland bugs aren't too bright, the space the bug moves 
 * to (or if it elects to stay in the current location) is randomly selected. 
 * 
 * Also, a Flatland bug must mate or fight if it shares a location with another bug.
    * If the two bugs are the same gender, they will fight.  
    * In a bug fight, only one of the bugs will survive. 
      - As the bugs are all the same, the bug that survives is just random selection.  
    * If the two bugs are of differing genders, they will mate and produce a new bug.
    
* A new bug 
    * is placed at a randomly chosen location within the range.
    * has its gender randomly chosen.
* 
 * 
 */
public class Bug {
    
    /**
     * Questions:
     *  * Do can bugs move 8 spaces over x & y coord?
     *  * 
     */

    private int xCoord;

    public int getXcoord() {
        return xCoord;
    }

    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }
    
    
    private int yCoord;

    public int getYCoord() {
        return yCoord;
    }

    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }
    

    private int rangeLimit;

    public int getRangeLimit() {
        return rangeLimit;
    }

    public void setRangeLimit(int rangeLimit) {
        this.rangeLimit = rangeLimit;
    }
    
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    private boolean isSquashed = false;
    
    public boolean checkPulse() {
        return this.isSquashed;
    }
    
    public void squashBug() {
        this.isSquashed = true;
    }
    


    
}
