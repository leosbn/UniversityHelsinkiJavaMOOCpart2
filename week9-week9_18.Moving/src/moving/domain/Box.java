package moving.domain;

import java.util.ArrayList;

public class Box implements Thing {

    private int maximumCapacity;
    private ArrayList<Item> items;

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.items = new ArrayList<Item>();
    }

    public boolean addThing(Thing thing) {
        if (thing.getVolume()+ this.getVolume() <= this.maximumCapacity) {
            Item item = (Item) thing;
            items.add(item);
            return true;
        }
        return false;
    }

    public int getVolume() {
        int total = 0;
        for (Thing thing : this.items) {
            total += thing.getVolume();
        }
        return total;
    }
}
