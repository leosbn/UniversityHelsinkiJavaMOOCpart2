
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays;

public class Participant implements Comparable<Participant> {

    private String name;
    private int points;
    private ArrayList<Integer> jumps;
    private Random randomNum;

    public Participant(String name) {
        this.name = name;
        this.points = 0;
        this.jumps = new ArrayList<Integer>();
        this.randomNum = new Random();
    }

    public String getName() {
        return this.name;
    }

    public int getPoints() {
        return this.points;
    }
    
    public ArrayList<Integer> getJumps(){
        return this.jumps;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.getPoints() + " points)";
    }

    @Override
    public int compareTo(Participant participant) {
        return this.points - participant.points;
    }

    public int jump() {
        int randomLengthOfJump = this.randomNum.nextInt(60) + 60;
        this.jumps.add(randomLengthOfJump);
        this.points += randomLengthOfJump;
        return randomLengthOfJump;
    }

    public int[] takeAndStorePointsFromJudges() {
        int[] allPoints = new int[5];
        int pointsOfJudge1 = this.randomNum.nextInt(10) + 10;
        int pointsOfJudge2 = this.randomNum.nextInt(10) + 10;
        int pointsOfJudge3 = this.randomNum.nextInt(10) + 10;
        int pointsOfJudge4 = this.randomNum.nextInt(10) + 10;
        int pointsOfJudge5 = this.randomNum.nextInt(10) + 10;
        allPoints[0] = pointsOfJudge1;
        allPoints[1] = pointsOfJudge2;
        allPoints[2] = pointsOfJudge3;
        allPoints[3] = pointsOfJudge4;
        allPoints[4] = pointsOfJudge5;
        Arrays.sort(allPoints);
        this.points += allPoints[1] + allPoints[2] + allPoints[3];
        return allPoints;
    }
}
