
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class UserInterface {

    private Scanner scanner;
    private List<Person> contactList;
    private Map<String, String> listOfNumbers;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.contactList = new ArrayList<Person>();
        this.listOfNumbers = new HashMap<String, String>();
    }

    public void start() {
        System.out.println("phone search\n"
                + "available operations:");
        System.out.println(" 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit\n");
        while (true) {
            System.out.print("command: ");
            String userInput = scanner.nextLine();
            if (userInput.equals("x")) {
                break;
            } else if (userInput.equals("1")) {
                this.addNumber();
            } else if (userInput.equals("2")) {
                this.searchByName();
            } else if (userInput.equals("3")) {
                this.searchByNumber();
            } else if (userInput.equals("4")) {
                this.addAddress();
            } else if (userInput.equals("5")) {
                this.showPersonalInfo();
            } else if (userInput.equals("6")) {
                this.deletePersonalInfo();
            } else if (userInput.equals("7")) {
                this.searchByKeyWord();
            }
        }
    }

    public void addNumber() {
        System.out.print("whose number: ");
        String name = scanner.nextLine();
        System.out.print("number: ");
        String number = scanner.nextLine();
        for (Person person : this.contactList) {
            if (name.equals(person.getName())) {
                person.addNumber(number);
                this.listOfNumbers.put(number, name);
                return;
            }
        }
        this.contactList.add(new Person(name, number));
        this.listOfNumbers.put(number, name);
    }

    public void searchByName() {
        System.out.print("whose number: ");
        String nameSearched = scanner.nextLine();
        for (Person person : this.contactList) {
            if (person.getName().equalsIgnoreCase(nameSearched)) {
                for (String number : person.getNumbers()) {
                    System.out.println(" " + number);
                }
                return;
            }
        }
        System.out.println("  not found");
    }

    public void searchByNumber() {
        System.out.print("number: ");
        String number = scanner.nextLine();
        if (!this.listOfNumbers.containsKey(number)) {
            System.out.println(" not found");
        } else {
            System.out.println(this.listOfNumbers.get(number));
        }
    }

    public void addAddress() {
        System.out.print("whose address: ");
        String name = scanner.nextLine();
        System.out.print("street: ");
        String addressStreet = scanner.nextLine();
        System.out.print("city: ");
        String addressCity = scanner.nextLine();

        for (Person person : this.contactList) {
            if (name.equals(person.getName())) {
                person.addAddress(addressStreet, addressCity);
                return;
            }
        }
        this.contactList.add(new Person(name, addressStreet, addressCity));
    }

    public void showPersonalInfo() {
        System.out.print("whose information: ");
        String name = scanner.nextLine();
        for (Person person : this.contactList) {
            //if name is found in the list
            if (person.getName().equals(name)) {
                //print address
                System.out.println(person.getAddress());
                //print numbers
                if (person.getNumbers().isEmpty()) {
                    System.out.println("  phone number not found");
                } else {
                    System.out.println("  phone numbers: ");
                    for (String number : person.getNumbers()) {
                        System.out.println("   " + number);
                    }
                    return;
                }
            }
        }
        System.out.println("  not found");
    }

    public void deletePersonalInfo() {
        System.out.print("whose information: ");
        String name = scanner.nextLine();
        for (Person person : this.contactList) {
            if (person.getName().equals(name)) {
                person.deletePersonalInformation();
            }
        }
        this.listOfNumbers.clear();
        for (Person person : this.contactList) {
            for (String number : person.getNumbers()) {
                this.listOfNumbers.put(number, person.getName());
            }
        }
    }

    public void searchByKeyWord() {
        System.out.print("keyword (if empty, all listed): ");
        String word = scanner.nextLine();
        List<Person> keysRetrieved = new ArrayList<Person>();
        if (word.isEmpty()) {
            keysRetrieved.addAll(contactList);
            Collections.sort(keysRetrieved);
            for (Person person : keysRetrieved) {
                System.out.println("");
                System.out.println(" " + person.getName());
                System.out.println("  address: " + person.getAddress());
                if (person.getNumbers().isEmpty()) {
                    System.out.println("  phone number not found");
                } else {
                    System.out.println("  phone numbers: ");
                    for (String number : person.getNumbers()) {
                        System.out.println("   " + number);
                    }
                }
            }
        } else {
            for (Person person : this.contactList) {
                if (person.getName().contains(word) || person.getAddress().contains(word)) {
                    keysRetrieved.add(person);
                }
            }
        }
        Collections.sort(keysRetrieved);
        for (Person person : keysRetrieved) {
            System.out.println("");
            System.out.println(" " + person.getName());
            System.out.println("  address: " + person.getAddress());
            if (person.getNumbers().isEmpty()) {
                System.out.println("  phone number not found");
            } else {
                System.out.println("  phone numbers: ");
                for (String number : person.getNumbers()) {
                    System.out.println("   " + number);
                }
            }
        }
        if (keysRetrieved.isEmpty()) {
            System.out.println(" keyword not found");
        }
    }
}
