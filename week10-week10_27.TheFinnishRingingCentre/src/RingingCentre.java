
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class RingingCentre {

    private Map<Bird, List<String>> ringingcentre;

    public RingingCentre() {
        this.ringingcentre = new HashMap<Bird, List<String>>();
    }

    public void observe(Bird bird, String place) {
        if (!this.ringingcentre.containsKey(bird)) {
            this.ringingcentre.put(bird, new ArrayList<String>());
        }
        this.ringingcentre.get(bird).add(place);
    }

    public void observations(Bird bird) {
        System.out.print(bird + " observations: ");
        if (!this.ringingcentre.containsKey(bird)) {
            System.out.println("0");
        } else {
            System.out.println(this.ringingcentre.get(bird).size());
            for (Bird observedBird : this.ringingcentre.keySet()) {
                
                if (observedBird.equals(bird)) {
                    for (String place : this.ringingcentre.get(bird)) {
                        System.out.println(place);
                    }
                }
            }
        }
    }
}
