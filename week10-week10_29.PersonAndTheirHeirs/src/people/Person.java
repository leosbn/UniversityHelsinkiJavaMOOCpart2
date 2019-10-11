package people;

public class Person {

    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }
    
    public String toString(){
        return this.getName() + "\n" + "  " + this.getAddress();
    }
}
