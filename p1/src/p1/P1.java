// Connor Stanford  
// cxs0290
// CMPS 360
// Programming Project : #1
// Due Date : 9.6.16
// Program Description: (insert description here)
// Certificate of Authenticity:
// I certify that the code in the method functions including
// method function main of dataWrapper project are entirely my own
// work. 

package p1;

/**
 *
 * @author cxs0290
 */
public class P1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Grab input from user:
        /**
         *  Num of bugs initially in farm.
         *  Upper range, 1 - 99 inclusive.
         *  Num of times alive bugs will move (potentially fight and mate.)
         *  The name of the report file.
         * 
         * Note: preserve original num of bugs, male/female bugs.
        */
        
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        System.out.print("Enter the number of bugs initially in the farm: ");
        int numOfInitialBugs = scanner.nextInt();
        
        System.out.print("Enter the number of bug moves: ");
        int numOfBugMoves = scanner.nextInt();
        
        System.out.print("Enter the upper bound for the x coordinate (1 - 99): ");
        int XCoordUpperBound = scanner.nextInt();

        System.out.print("Enter the upper bound for the y coordinate (1 - 99): ");
        int YCoordUpperBound = scanner.nextInt();
        
        System.out.print("Enter the file name where results will be recorded: ");
        String outputFile = scanner.next();
        
        
        BugFarm mcdonaldsFarm = new BugFarm(numOfInitialBugs, numOfBugMoves, 
            XCoordUpperBound, YCoordUpperBound);
        
        mcdonaldsFarm.initSimulation();
        mcdonaldsFarm.collectBugStats(outputFile);
                  
    }

}
