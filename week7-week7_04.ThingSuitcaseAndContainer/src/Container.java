
import java.util.ArrayList;

public class Container {

    private int maxWeight;
    private ArrayList<Suitcase> cases;

    public Container(int maxWeight) {
        this.maxWeight = maxWeight;
        this.cases = new ArrayList<Suitcase>();
    }

    public String toString() {
        int numberOfSuitcases = 0;
        int totalWeight = 0;
        for (Suitcase eachCase : this.cases) {
            numberOfSuitcases++;
            totalWeight += eachCase.totalWeight();
        }
        if (numberOfSuitcases == 0) {
            return "empty (0 kg)";
        } else if (numberOfSuitcases == 1) {
            return "1 suitcase (" + totalWeight + " kg)";
        } else {
            return numberOfSuitcases + " suitcases (" + totalWeight + " kg)";
        }
    }
    
    public int totalWeight() {
        int totalWeight = 0;
        for (Suitcase eachCase : this.cases) {
            totalWeight += eachCase.totalWeight();
        }
        return totalWeight;
    }
    
    public void addSuitcase(Suitcase suitcase){
        if (suitcase.totalWeight()+this.totalWeight() <= this.maxWeight) {
            this.cases.add(suitcase);
        }
    }
    
    public void printThings() {
        for (Suitcase suitcase : this.cases) {
            suitcase.printThings();
        }
    }
}
