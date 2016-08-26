
package p1;

import java.util.Objects;

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
public class Bug implements Comparable<Bug>{
    
    /**
     * Questions:
     *  * Do can bugs move 8 spaces over x & y coord?
     *  * 
     */

    public class BugCoordinates {
        private int xCoord;
        private int yCoord;
    }

    BugCoordinates bugCoords;
    private int rangeLimit;
    private String gender;
    private boolean isSquashed;
    
    public Bug() { bugCoords = new BugCoordinates(); this.isSquashed = false; }
    
    public Bug(int xCoord, int yCoord, int rangeLimit, String gender) {
        bugCoords = new BugCoordinates();
        this.bugCoords.xCoord = xCoord;
        this.bugCoords.yCoord = yCoord;
        this.rangeLimit = rangeLimit;
        this.gender = gender;
        this.isSquashed = false;
    }
    
    @Override
    public int compareTo(Bug enemyBug) {
     
        if (this.bugCoords.xCoord > enemyBug.bugCoords.xCoord &&
            this.bugCoords.yCoord > enemyBug.bugCoords.yCoord) {
            return 1;
        }
        
        if (this.bugCoords.xCoord == enemyBug.bugCoords.xCoord && 
            this.bugCoords.yCoord == enemyBug.bugCoords.yCoord) {
            return 0;
        }
     
        return -1;
    }
    
    @Override
    public boolean equals(Object obj) {

        if (obj == this) { return true; }
        
        if (!(obj instanceof Bug)) {
            return false;
        }
        
        Bug passedBug = (Bug) obj;
        
        return this.bugCoords.xCoord == passedBug.bugCoords.xCoord &&
               this.bugCoords.yCoord == passedBug.bugCoords.yCoord;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.bugCoords);
        return hash;
    }


    
    public BugCoordinates getBugCoordinates() {
        return this.bugCoords;
    }
    
    public void setBugCoordinates(int xCoord, int yCoord) {
        this.bugCoords.xCoord = xCoord;
        this.bugCoords.yCoord = yCoord;
    }
       
    
    public int getRangeLimit() {
        return rangeLimit;
    }

    public void setRangeLimit(int rangeLimit) {
        this.rangeLimit = rangeLimit;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public boolean checkPulse() {
        return this.isSquashed;
    }
    
    public void squashBug() {
        this.isSquashed = true;
    }
    
    
}
