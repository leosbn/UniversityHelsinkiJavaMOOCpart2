
import java.util.List;
import java.util.ArrayList;

public class Person implements Comparable<Person> {

    private String name;
    private List<String> numbers;
    private Address address;

    public Person(String name, String number) {
        this.name = name;
        this.numbers = new ArrayList<String>();
        this.numbers.add(number);
        this.address = new Address();
    }

    public Person(String name, String addrStr, String addrCit) {
        this.name = name;
        this.numbers = new ArrayList<String>();
        this.address = new Address(addrStr, addrCit);
    }

    public String getName() {
        return this.name;
    }

    public List<String> getNumbers() {
        return this.numbers;
    }

    public void addNumber(String number) {
        this.numbers.add(number);
    }

    public void addAddress(String addrStr, String addrCit) {
        this.address.addStreet(addrStr);
        this.address.addCity(addrCit);
    }

    public String getAddress() {
        if (this.address.getCity().isEmpty() && this.address.getStreet().isEmpty()) {
            return "  address unknown";
        }
        return "  address: " + this.address.getStreet() + " " + this.address.getCity();
    }

    public void deletePersonalInformation() {
        this.name = "";
        this.numbers.clear();
        this.address.remove();
    }

    @Override
    public int compareTo(Person o) {
        return this.getName().compareTo(o.getName());
    }
}
