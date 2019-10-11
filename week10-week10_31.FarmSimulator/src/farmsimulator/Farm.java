package farmsimulator;

import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive {

    private String owner;
    private Barn barn;
    private List<Cow> herd;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.herd = new ArrayList<Cow>();
    }

    public String getOwner() {
        return this.owner;
    }

    public void liveHour() {
        for (Alive alive : this.herd) {
            alive.liveHour();
        }
    }

    public void addCow(Cow cow){
        this.herd.add(cow);
    }
    
    public void manageCows(){
        this.barn.takeCareOf(this.herd);
    }
    
    public void installMilkingRobot(MilkingRobot robot){
        this.barn.installMilkingRobot(robot);
    }

    public String toString() {
        String text = "Farm owner: " + this.getOwner() + "\nBarn bulk tank: " + 
                this.barn.getBulkTank() + "\n";
        if(this.herd.isEmpty()){
            text+="No cows.";
        } else {
            text+="Animals:";
            for(Alive cow : this.herd){
                text+="\n        " + cow;
            }
        }
        return text;
    }
}
