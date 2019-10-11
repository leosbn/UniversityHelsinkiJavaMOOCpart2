
import java.util.Collections;
import java.util.Scanner;

/**
 * this class handles the printed interface that the user can see
 */
public class UserInterface {

    private Scanner reader;
    private Participants participants;
    private int roundNumber = 1;

    public UserInterface() {
        this.reader = new Scanner(System.in);
        this.participants = new Participants();
    }

    /**
     * this method is where the application starts
     */
    public void start() {
        System.out.println("Kumpula ski jumping week");
        System.out.println("");
    }

    /**
     * this method gets participants on board. if an empty line is entered, the
     * method goes on with the execution
     */
    public void insertParticipants() {
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        while (true) {
            System.out.print("  Participant name: ");
            String participantName = reader.nextLine();
            if (participantName.isEmpty()) {
                break;
            }
            Participant participant = new Participant(participantName);
            this.participants.addParticipant(participant);
        }
        System.out.println("\nThe tournament begins!");
    }

    /**
     * this method either makes the athletes jump or it goes to the results
     */
    public void roundsMenu() {
        while (true) {
            System.out.print("\nWrite \"jump\" to jump; otherwise you quit: ");
            String action = reader.nextLine();
            if (action.equalsIgnoreCase("jump")) {
                jump();
                roundNumber++;
            } else {
                conclusion(this.participants);
                break;
            }
            System.out.println("");
        }
    }

    /**
     * this method tracks the round number and lists the participants based on
     * their points
     */
    public void jump() {
        System.out.println("\nRound " + roundNumber);
        System.out.println("\nJumping order:");
        orderAndShow(this.participants);
    }

    public void orderAndShow(Participants participants) {
        participants.sortParticipants();
        participants.printParticipants();
        showRoundResults(this.participants);
    }

    public void showRoundResults(Participants participants) {
        System.out.println("Results of round " + roundNumber);
        participants.printResultsForParticipants();
        System.out.println("");
    }
    
    public void conclusion(Participants participants){
        System.out.println("\nThanks!");
        System.out.println("");
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        participants.printConclusion();
    }
}
