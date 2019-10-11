package farmsimulator;

public class MilkingRobot {

    private BulkTank tank;

    public MilkingRobot() {

    }
    
    public BulkTank getBulkTank(){
        return this.tank;
    }
    
    public void setBulkTank(BulkTank tank){
        this.tank=tank;
    }
    
    public void milk(Milkable milkable){
        if(this.tank==null){
            throw new IllegalStateException("no robot installed");
        }
        this.tank.addToTank(milkable.milk());
    }

}
