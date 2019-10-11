package boxes;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class MaxWeightBox extends Box {

    private int maxWeight;
    private Collection<Thing> box;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.box=new ArrayList<Thing>();
    }
    
    public boolean isInTheBox(Thing thing){
        if(this.box.contains(thing)){
            return true;
        }
        return false;
    }
    
    public void add(Thing thing){
        int weightInBox=0;
        for(Thing thingAlreadyBoxed : this.box){
            weightInBox+=thingAlreadyBoxed.getWeight();
        }
        if(weightInBox+thing.getWeight()<=this.maxWeight){
            this.box.add(thing);
        }
    }
    
}
