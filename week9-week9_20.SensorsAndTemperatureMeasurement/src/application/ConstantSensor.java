package application;

public class ConstantSensor implements Sensor {

    private int parameter;

    public ConstantSensor(int parameter) {
        this.parameter = parameter;
    }

    public boolean isOn() {
        return true;
    }

    public void on() {

    }

    public void off() {

    }

    public int measure() {
        return this.parameter;
    }
}
