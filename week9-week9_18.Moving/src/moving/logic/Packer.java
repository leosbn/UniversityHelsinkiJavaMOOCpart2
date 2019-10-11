package moving.logic;

import java.util.List;
import java.util.ArrayList;
import moving.domain.Box;
import moving.domain.Thing;

public class Packer {

    private int boxesVolume;
    private ArrayList<Box> boxes;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
        this.boxes = new ArrayList<Box>();
    }

    public List<Box> packThings(List<Thing> things) {
        List<Box> packedThings = new ArrayList<Box>();
        int i=0;
        for(Thing thing : things){
            packedThings.add(new Box(this.boxesVolume));
            packedThings.get(i).addThing(thing);
            i++;
        }
        return packedThings;
    }
}
