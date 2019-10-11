package clicker.applicationlogic;

public class PersonalCalculator implements Calculator {

    private int value;

    public PersonalCalculator() {
        this.value = 0;
    }

    public int giveValue() {
        return this.value;
    }

    public void increase() {
        this.value++;
    }
}
