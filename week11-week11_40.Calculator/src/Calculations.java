
public class Calculations {

    private int total;

    public Calculations() {
        this.total = 0;
    }

    public String operationAdd(String number) throws NumberFormatException {
        this.total += Integer.parseInt(number);
        return Integer.toString(this.total);
    }

    public String operationSubtract(String number) throws NumberFormatException {
        this.total -= Integer.parseInt(number);
        return Integer.toString(this.total);
    }

    public String reset() {
        this.total = 0;
        return Integer.toString(total);
    }

    public String getTotalString() {
        return Integer.toString(this.total);
    }
}
