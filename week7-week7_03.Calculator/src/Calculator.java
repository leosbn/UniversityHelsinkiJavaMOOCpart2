
public class Calculator {

    private Reader reader;
    private int operationsNumber;

    public Calculator() {
        this.reader = new Reader();
        this.operationsNumber=0;
    }

    public void start() {
        while (true) {
            System.out.println("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }
            if (command.equals("sum")) {
                sum();
                this.operationsNumber++;
            }
            if (command.equals("difference")) {
                difference();
                this.operationsNumber++;
            }
            if (command.equals("product")) {
                product();
                this.operationsNumber++;
            }
        }
        statistics();
    }

    private void sum() {
        int[] values = input();
        int sum = values[0] + values[1];
        System.out.println("sum of the values " + sum);
    }

    private void difference() {
        int[] values = input();
        int difference = values[0] - values[1];
        System.out.println("difference of the values " + difference);
    }

    private void product() {
        int[] values = input();
        int product = values[0] * values[1];
        System.out.println("product of the values " + product);
    }

    private int[] input() {
        int[] input = new int[2];
        System.out.println("value1: ");
        input[0] = reader.readInteger();
        System.out.println("value2: ");
        input[1] = reader.readInteger();
        return input;
    }
    
    private void statistics(){
        System.out.println("Calculations done " + this.operationsNumber);
    }
}
