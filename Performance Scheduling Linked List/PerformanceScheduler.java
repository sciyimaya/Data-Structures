import java.util.Scanner;

/**
 * @author Suheyla Ceyda Iyimaya
 */

/**
 * The main driver for the class.
 */
public class PerformanceScheduler {
    public static void main(String[] args){
        boolean q = true;
        boolean t = true;
        PerformanceList list = new PerformanceList();
        while(q == true){
            System.out.println("Main Menu:");
            System.out.println("A) Add to end");
            System.out.println("B) Move current node backward");
            System.out.println("C) Display current node");
            System.out.println("D) Display all nodes");
            System.out.println("F) Move current node forward");
            System.out.println("I) Insert after current node");
            System.out.println("J) Jump to position");
            System.out.println("R) Remove current node");
            System.out.println("Q) Exit");
            Scanner myscanner = new Scanner(System.in);
            System.out.print("Choose an operation: ");
            String input = myscanner.nextLine();
            input = input.trim();
            input = input.toUpperCase();
            char choice = (char)input.charAt(0);
            if(choice == 'Q'){
                System.out.println("Program terminating normally...");
                System.exit(0);
            }
            else if(choice == 'A'){
                Scanner input1 = new Scanner(System.in);
                System.out.print("Enter name of performance: ");
                String performanceName = input1.nextLine();
                Scanner input2 = new Scanner(System.in);
                System.out.print("Enter name of lead performer: ");
                String leadPerformer = input2.nextLine();
                Scanner input3 = new Scanner(System.in);
                System.out.print("Enter the total participants: ");
                String index = input3.nextLine();
                int totalParticipants = Integer.parseInt(index);
                Scanner input4 = new Scanner(System.in);
                System.out.print("Enter the duration of the performance: ");
                String index2 = input4.nextLine();
                int duration = Integer.parseInt(index2);
                PerformanceNode performance1 = new PerformanceNode
                        (performanceName, leadPerformer, totalParticipants,
                                duration);
                list.addToEnd(performance1);
                System.out.println("New performance " + performanceName
                        + " is added to the end of the list.");
            }
            else if(choice == 'B'){
                if(list.moveCursorBackward() == true){
                    System.out.println("Cursor has been moved backwards.");
                }
                else{
                    System.out.println("Cursor is already at the beginning of "
                            + "the list. Cursor cannot be moved backwards.");
                }
            }
            else if(choice == 'C'){
                System.out.println("Current Node:");
                System.out.println();
                list.displayCurrentPerformance();
            }
            else if(choice == 'D'){
                System.out.println(list.toString());
            }
            else if(choice == 'F'){
                if(list.moveCursorForward() == true){
                    System.out.println("Cursor has been moved forwards.");
                }
                else{
                    System.out.println("Cursor is already at the end of the "
                            + "list. Cursor cannot be moved forwards.");
                }
            }
            else if(choice == 'I'){
                Scanner input1 = new Scanner(System.in);
                System.out.print("Enter name of performance: ");
                String performanceName = input1.nextLine();
                Scanner input2 = new Scanner(System.in);
                System.out.print("Enter name of lead performer: ");
                String leadPerformer = input2.nextLine();
                Scanner input3 = new Scanner(System.in);
                System.out.print("Enter the total participants: ");
                String index = input3.nextLine();
                int totalParticipants = Integer.parseInt(index);
                Scanner input4 = new Scanner(System.in);
                System.out.print("Enter the duration of the performance: ");
                String index2 = input4.nextLine();
                int duration = Integer.parseInt(index2);
                PerformanceNode performance1 = new PerformanceNode
                        (performanceName, leadPerformer, totalParticipants,
                                duration);
                list.addAfterCurrent(performance1);
                System.out.println("New performance " + performanceName
                        + " is added after the current performance.");
            }
            else if(choice == 'J'){
                Scanner input1 = new Scanner(System.in);
                System.out.print("Enter the position: ");
                String c  = input1.nextLine();
                int pos = Integer.parseInt(c);
                if(list.jumpToPosition(pos) == true){
                    System.out.println("Cursor has been moved to position "
                            + pos + ".");
                }
                else{
                    System.out.println("Error: There is no such position");
                }
            }
            else if(choice == 'R'){
                String prevCursor = list.getCursor().getPerformanceName();
                if(list.removeCurrentNode() == true){
                    System.out.println("Performance "+ prevCursor + " has "
                            + "been removed");
                }
                else{
                    System.out.println("There is no current node");
                }
            }
            else{
                System.out.println("Invalid Choice. Please Try Again");
            }
            System.out.println();
        }
    }
}
