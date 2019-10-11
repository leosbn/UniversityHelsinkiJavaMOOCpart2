import java.util.ArrayList;

public class Flights {
    private ArrayList<Flight> flights;
    
    public Flights(){
        this.flights=new ArrayList<Flight>();
    }
    
    public void addFlight(Flight flight){
        this.flights.add(flight);
    }
    
    public void printAllFlights(){
        for(Flight flight:this.flights){
            System.out.println(flight);
        }
    }
}
