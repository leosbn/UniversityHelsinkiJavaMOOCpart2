
public class Flight {
    private Plane plane;
    private String departure;
    private String arrival;
    
    public Flight(Plane plane, String departure, String arrival){
        this.plane=plane;
        this.departure=departure;
        this.arrival=arrival;
    }
    
    public Plane getPlane(){
        return this.plane;
    }
    
    public String getDeparture(){
        return this.departure;
    }
    
    public String getArrival(){
        return this.arrival;
    }
    
    public String toString(){
        return this.plane + " (" + this.departure + "-" + this.arrival + ")";
    }
}
