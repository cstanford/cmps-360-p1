
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
public class Bug implements Comparable<Bug>{
    

    public class BugCoordinates {
        private int xCoord;
        private int yCoord;
    }
    
    private int xCoord;
    private int yCoord;
    private int rangeLimit;
    private String gender;
    private boolean isAlive;
    
    public Bug() { 
        this.isAlive = true;
        setGender();
    }
    
    public Bug(int xCoord, int yCoord, int rangeLimit) {
 
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.rangeLimit = rangeLimit;
        this.isAlive = false;
        setGender();
    }
    
    @Override
    public int compareTo(Bug passedBug) {
     
        if (this.xCoord > passedBug.xCoord &&
            this.yCoord > passedBug.yCoord) {
            return 1;
        }
        
        if (this.xCoord == passedBug.xCoord && 
            this.yCoord == passedBug.yCoord) {
            return 0;
        }
     
        return -1;
    }
    
    @Override
    public boolean equals(Object obj) {

        if (obj == this) { return false; } 
        // We return false here to ensure that the bug does not attmept
        // to fight or mate with itself when the simulatoin is ran. 
        
        if (!(obj instanceof Bug)) {
            return false;
        }
        
        Bug passedBug = (Bug) obj;
        
        return this.xCoord == passedBug.xCoord &&
               this.yCoord == passedBug.yCoord;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.xCoord;
        hash = 31 * hash + this.yCoord;
        return hash;
    }

    
    public int getXCoordinate() {
        return this.xCoord;
    }
    
    public int getYCoordinate() {
        return this.yCoord;
    }
    
    public void setBugCoordinates(int xCoord, int yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
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

    private void setGender() {
        
        int randInt = (int)(Math.random() * 2);
        
        if (randInt < 1){
            this.gender = "Male";
        } 
        else { this.gender = "Female"; }
    }
    
    public boolean checkPulse() {
        return this.isAlive;
    }
    
    public void squashBug() {
        this.isAlive = false;
    }
    
    
}
