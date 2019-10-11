import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //inizializzo il codice dell'aereoporto
        Scanner reader = new Scanner(System.in);
        UserInterface ui = new UserInterface(reader);
        ui.start();
    }
}
