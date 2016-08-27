// Connor Stanford  
// cxs0290
// CMPS 360
// Programming Project : #1
// Due Date : 8.30.16
// Program Description: (insert description here)
// Certificate of Authenticity:
// I certify that the code in the method functions including
// method function main of this project are entirely my own
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
        
        
        Bug b1 = new Bug();
        Bug b2 = new Bug();
        Bug b3 = new Bug();
        
        b1.setBugCoordinates(1, 1);
        b2.setBugCoordinates(1, 1);
        b3.setBugCoordinates(2,2);
        
        boolean result1 = b1.equals(b2); // true
        boolean result2 = b1.equals(b3); // false
        
        System.out.print("b1 == b2: " + result1 + "\n"); // true
        System.out.print("b1 == b3: " + result2 + "\n"); // false
        
        int result3 = b1.compareTo(b2); // 0
        int result4 = b3.compareTo(b2); // 1
        int result5 = b1.compareTo(b3); // -1 
        
        System.out.print("Should be 0: " + result3 + "\n"); 
        System.out.print("Should be 1: " + result4 + "\n");        
        System.out.print("Should be -1: " + result5 + "\n"); 
        
        BugFarm mcdonaldsFarm = new BugFarm(numOfInitialBugs, numOfBugMoves, 
            XCoordUpperBound, YCoordUpperBound);
        
        mcdonaldsFarm.displayBugStats();

          

    }

}
