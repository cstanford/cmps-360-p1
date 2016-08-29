
package p1;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author cxs0290
 */

/**
 * A bug farm manages a collection of bugs.  The bug farm is responsible for 
 * initially placing some bugs into the collection, the range of the bugs in the
 * collection, makes the alive bugs in the collection move (including mate and fight) 
 * a predetermined number of times and provides the means to display the number
 * of alive bugs, the number of dead bugs, the number of alive bugs of gender 
 * male, the number number of alive bugs of gender female, the number of dead 
 * bugs of gender male and the number of dead bugs of gender female.
 * 
 */
public class BugFarm {
    
    private final int xCoordUpperBound;
    private final int yCoordUpperBound;
    private final int numOfInitialBugs;
    private final int numOfBugMoves;
    private int initialMaleBugs;
    private int initialFemaleBugs;
    private final ArrayList<Bug> bugList;
    
    
    
    public BugFarm(int numOfInitialBugs, int numOfBugMoves, int xCoordUpperBound,
                   int yCoordUpperBound) {
                
        this.numOfInitialBugs = numOfInitialBugs;
        this.numOfBugMoves = numOfBugMoves;
        this.xCoordUpperBound = xCoordUpperBound;
        this.yCoordUpperBound = yCoordUpperBound;
        this.bugList = new ArrayList<>();
        
        initBugFarm();
        initSimulation();
        
    }
    
    
    private void initBugFarm() {
        
        for (int i = 0; i < numOfInitialBugs; i++){
            
            Bug newBug = new Bug();
           
            if (Objects.equals("Male", newBug.getGender())){
                this.initialMaleBugs++;
            } 
            else { this.initialFemaleBugs++; }
            
            int xCoord = (int)((Math.random() * this.xCoordUpperBound));
            int yCoord = (int)((Math.random() * this.yCoordUpperBound));
            
            newBug.setBugCoordinates(xCoord, yCoord);
            
            this.bugList.add(newBug);
            
        }
        
    }
    
    private void initSimulation() {
        
        this.bugList.stream().forEach((bug) -> {
            moveBug(bug);
        }); 
        
        int turnNumber = 0;
        
        while (turnNumber < this.numOfBugMoves){
            
            int limit = this.bugList.size();
            int babysToMake = 0;
            
            for (int i = 0; i < limit - 1; i++){          
                Bug bug1 = this.bugList.get(i);
                
                for (int k = i + 1; k < limit; k++){
                    Bug bug2 = this.bugList.get(k);
                    
                    // Need to make insert checks for when a bug is dead!
                    // We can use continue when a bug dies...
                    
                    if (bug1.equals(bug2)){  
                        makeLoveOrWar(bug1, bug2);
                    }
                }
            }
            makeLove(babysToMake);
            turnNumber++;
        }

    }
    
    public void moveBug(Bug bug) {
        //TODO: make sure bugs stay in range
        
        int xCoord = bug.getXCoordinate();
        int yCoord = bug.getYCoordinate();
                
        int diceRoll = (int)((Math.random() * 9));
        
        switch (diceRoll) {
            case 8: bug.setBugCoordinates(xCoord + 1, yCoord + 1);
                    break;
            case 7: bug.setBugCoordinates(xCoord , yCoord - 1);
                    break;
            case 6: bug.setBugCoordinates(xCoord - 1, yCoord - 1);
                    break;             
            case 5: bug.setBugCoordinates(xCoord + 1, yCoord);
                    break;
            case 4: bug.setBugCoordinates(xCoord - 1, yCoord);
                    break;
            case 3: bug.setBugCoordinates(xCoord + 1, yCoord + 1);
                    break;
            case 2: bug.setBugCoordinates(xCoord, yCoord + 1);
                    break;
            case 1: bug.setBugCoordinates(xCoord - 1, yCoord + 1);
                    break;
            default: // Bug stays in place. Do nothing.
                    break;  
        }
           
    }
    
    private void makeLoveOrWar(Bug bug1, Bug bug2){
        
        // If the bug is dead, do nothing. 
        if ((bug2.checkPulse())) { return; }
        
        if (Objects.equals(bug1.getGender(), bug2.getGender())){
            int duel = (int)((Math.random() * 2));
            System.out.print("\nTwo bugs fought to the death!");

            if (duel < 1) {
                bug1.squashBug();
                return;
            } 
            bug2.squashBug();
            
        } else {
            Bug babyBug = new Bug();
            this.bugList.add(babyBug);
            System.out.print("\nBaby making time...!");
        }
        
        
    }
    
    private void makeWar(Bug bug1, Bug bug2) { 
        
        int duel = (int)((Math.random() * 2));
        System.out.print("\nTwo bugs fought to the death!");

        if (duel < 1) {
            bug1.squashBug();
            return;
        } 
        bug2.squashBug();
    }
    
    private void makeLove(int babysToMake) {
        
        for(int i = 0; i < babysToMake; i++) {
            Bug babyBug = new Bug();
            this.bugList.add(babyBug);
            System.out.print("\nBaby making time...!");

        }
    }
    
    
    
    public void displayBugStats() {
        
        System.out.print("\nBug Farm Stats: ");
        System.out.print("\nInititial number of Bugs: " + this.numOfInitialBugs);
        System.out.print("\nInitial bugs of type male: " + this.initialMaleBugs);
        System.out.print("\nInitial bugs of type female: " + this.initialFemaleBugs);
        
        System.out.print("\n\nAfter simulation results: ");
        
       
    }

}
