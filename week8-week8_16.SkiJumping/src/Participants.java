
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Participants {

    private ArrayList<Participant> listOfParticipants;

    public Participants() {
        this.listOfParticipants = new ArrayList<Participant>();
    }

    public void addParticipant(Participant participant) {
        this.listOfParticipants.add(participant);
    }

    public void sortParticipants() {
        Collections.sort(listOfParticipants);
    }

    public void printParticipants() {
        int i = 0;
        while (i < this.listOfParticipants.size()) {
            System.out.println("  " + (i + 1) + ". " + this.listOfParticipants.get(i));
            i++;
        }
    }

    public void printResultsForParticipants() {
        for (Participant participant : listOfParticipants) {
            System.out.println("  " + participant.getName());
            System.out.println("    length: " + participant.jump());
            System.out.println("    judge votes: " + Arrays.toString(participant.takeAndStorePointsFromJudges()));
        }
    }

    public void printConclusion() {
        Collections.sort(listOfParticipants);
        Collections.reverse(listOfParticipants);
        for (Participant participant : listOfParticipants) {
            
            System.out.print((listOfParticipants.indexOf(participant)+1) + "           " + participant);
            System.out.println("");
            System.out.print("            jump lengths: ");
            for(int i=0;i<participant.getJumps().size();i++){
                if(i<participant.getJumps().size()-1){
                System.out.print(participant.getJumps().get(i) + " m, ");
                } else {
                    System.out.print(participant.getJumps().get(i) + " m");
                }
            }
            System.out.println("");
        }
    }

}
