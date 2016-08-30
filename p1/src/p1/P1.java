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

import java.io.PrintWriter;
import java.io.File;

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
        
        mcdonaldsFarm.initSimulation();
        
        BugFarm.SimulationDataWrapper dataWrapper = mcdonaldsFarm.getBugFarmData();
        
        
        
        File reportFile = new File(outputFile);
        PrintWriter pw = null;
        
        try {
            pw = new PrintWriter(reportFile);
            
            pw.print("\n\nBug Farm Stats: ");
            pw.print("\nInitial number of Bugs: " + dataWrapper.numOfInitialBugs);
            pw.print("\nInitial bugs of type male: " + dataWrapper.initialMaleBugs);
            pw.print("\nInitial bugs of type female: " + dataWrapper.initialFemaleBugs);

            pw.print("\n\nAfter simulation results: "); 
            pw.print("\nTotal Bugs: " + dataWrapper.totalBugs);
            pw.print("\nAlive Bugs: " + dataWrapper.totalLivingBugs);
            pw.print("\nDead Bugs: " + dataWrapper.totalDeadBugs);
            pw.print("\nMale Bugs: " + dataWrapper.totalMaleBugs);
            pw.print("\nMales Alive: " + dataWrapper.malesAlive);
            pw.print("\nMales Dead: " + dataWrapper.malesDead);
            pw.print("\nFemale Bugs: " + dataWrapper.totalFemaleBugs);
            pw.print("\nFemales Alive: " + dataWrapper.femalesAlive);
            pw.print("\nFemales Dead: " + dataWrapper.femalesDead);
            pw.print("\n\n");
        } catch (Exception e) {
            pw.println(e);
        }

        if (pw != null) {
            pw.close();
        }

          

    }

}
