
import java.util.ArrayList;

public class Box implements ToBeStored {

    private double maxWeight;
    private ArrayList<ToBeStored> things;

    public Box(double max) {
        this.maxWeight = max;
        this.things = new ArrayList<ToBeStored>();
    }

    public void add(ToBeStored stuff) {
        if (weight() + stuff.weight() <= this.maxWeight) {
            this.things.add(stuff);
        }
    }

    public double weight() {
        double totalW = 0;
        for (ToBeStored total : things) {
            totalW += total.weight();
        }
        return totalW;
    }

    public String toString() {
        return "Box: " + this.things.size() + " things, total weight " + weight() + " kg";
    }
}
