
import java.util.ArrayList;

public class Suitcase {

    private ArrayList<Thing> things;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.things = new ArrayList<Thing>();
        this.maxWeight = maxWeight;
    }

    public void addThing(Thing thing) {
        if (thing.getWeight() + totalWeight() <= this.maxWeight) {
            this.things.add(thing);
        }
    }

    public String toString() {
        int numberOfThings = 0;
        int totalWeight = 0;
        for (Thing eachThing : this.things) {
            numberOfThings++;
            totalWeight += eachThing.getWeight();
        }
        if (numberOfThings == 0) {
            return "empty (0 kg)";
        } else if (numberOfThings == 1) {
            return "1 thing (" + totalWeight + " kg)";
        } else {
            return numberOfThings + " things (" + totalWeight + " kg)";
        }
    }

    public void printThings() {
        for (Thing eachThing : this.things) {
            System.out.println(eachThing);
        }
    }

    public int totalWeight() {
        int totalWeight = 0;
        for (Thing eachThing : this.things) {
            totalWeight += eachThing.getWeight();
        }
        return totalWeight;
    }

    public Thing heaviestThing() {

        if (!this.things.isEmpty()) {
            Thing heaviest = this.things.get(0);
            for (Thing thing : this.things) {
                if (thing.getWeight() > heaviest.getWeight()) {
                    heaviest = thing;
                }
            }
            return heaviest;
        }
        return null;
    }
}
