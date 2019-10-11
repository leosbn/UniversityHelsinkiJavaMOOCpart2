package farmsimulator;
import java.util.Collection;
public class Barn {

    private BulkTank tank;
    private MilkingRobot robot;

    public Barn(BulkTank tank) {
        this.tank = tank;
        this.robot=new MilkingRobot();
    }

    public BulkTank getBulkTank() {
        return this.tank;
    }

    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.robot=milkingRobot;
        this.robot.setBulkTank(this.tank);
    }

    public void takeCareOf(Cow cow) {
        if(this.robot==null){
            throw new IllegalStateException("no robot installed");
        }
        this.robot.milk(cow);
    }
    
    public void takeCareOf(Collection<Cow> cows){
        if(this.robot==null){
            throw new IllegalStateException("no robot installed");
        }
        for(Milkable milkable : cows){
            this.robot.milk(milkable);
        }
    }
    
    public String toString(){
        return "Barn: " + this.getBulkTank();
    }
}
