package application;

import java.util.Random;

public class Thermometer implements Sensor {

    private boolean isThermoOn;
    private Random temperature;

    public Thermometer() {
        this.isThermoOn = false;
        this.temperature = new Random();
    }

    public boolean isOn() {
        return this.isThermoOn;
    }

    public void on() {
        this.isThermoOn = true;
    }

    public void off() {
        this.isThermoOn = false;
    }

    public int measure() {
        if (this.isThermoOn) {
            int temp = this.temperature.nextInt(60) - 30;
            return temp;
        } else {
            throw new IllegalStateException("thermometer is off");
        }
    }
}