
import java.util.ArrayList;

public class Planes {

    private ArrayList<Plane> planes;

    public Planes() {
        this.planes = new ArrayList<Plane>();
    }

    public void addPlane(Plane plane) {
        this.planes.add(plane);
    }

    public void printAllPlanes() {
        for (Plane plane : this.planes) {
            System.out.println(plane);
        }
    }

    public Plane getPlaneInfo(String planeSearched) {
        for (Plane plane : this.planes) {
            if (plane.getPlaneId().equalsIgnoreCase(planeSearched)) {
                return plane;
            }
        }
        return null;
    }
}
