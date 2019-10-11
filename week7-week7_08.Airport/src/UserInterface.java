
import java.util.Scanner;

public class UserInterface {
    
    private Scanner scanner;
    private Planes planes;
    private Flights flights;
    
    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.planes = new Planes();
        this.flights = new Flights();
    }
// questo è lo starter del programma

    public void start() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");
        airportOperation();
        startFlightService();
    }

// questa è la prima parte del programma
    public void airportOperation() {
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                addPlane();
            } else if (choice.equals("2")) {
                addFlight();
            } else if (choice.equals("x")) {
                break;
            }
        }
    }
    
    public void addPlane() {
        System.out.println("Give plane ID:");
        String planeId = scanner.nextLine();
        System.out.println("Give plane capacity:");
        int planeCapac = Integer.parseInt(scanner.nextLine());
        Plane plane = new Plane(planeId, planeCapac);
        this.planes.addPlane(plane);
    }
    
    public void addFlight() {
        System.out.println("Give plane ID:");
        String planeId = scanner.nextLine();
        System.out.println("Give departure airport code:");
        String departureCode = scanner.nextLine();
        System.out.println("Give destination airport code:");
        String arrivalCode = scanner.nextLine();
        Flight flight = new Flight(planeHelper(planeId), departureCode, arrivalCode);
        this.flights.addFlight(flight);
    }
    
    public Plane planeHelper(String planeId) {
        return this.planes.getPlaneInfo(planeId);
    }

// questa è la seconda parte del programma
    public void startFlightService() {
        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println("");
        flightService();
    }
    
    public void flightService() {
        while (true) {
            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                printPlanes();
            } else if (choice.equals("2")) {
                printFlights();
            } else if (choice.equals("3")) {
                printPlaneDetail();
            } else if(choice.equals("x")) {
                break;
            }
        }
    }
    
    public void printPlanes() {
        this.planes.printAllPlanes();
    }
    
    public void printFlights() {
        this.flights.printAllFlights();
    }
    
    public void printPlaneDetail() {
        System.out.println("Give plane ID:");
        String planeId = scanner.nextLine();
        System.out.println(this.planes.getPlaneInfo(planeId));
    }
}
