package boxes;

import java.util.ArrayList;

public class OneThingBox extends Box {

    private ArrayList<Thing> box;

    public OneThingBox() {
        this.box = new ArrayList<Thing>();
    }

    public boolean isInTheBox(Thing thing) {
        if(this.box.contains(thing)){
            return true;
        }
        return false;
    }
    
    public void add(Thing thing){
        if(this.box.size()<1){
            this.box.add(thing);
        }
    }
}
