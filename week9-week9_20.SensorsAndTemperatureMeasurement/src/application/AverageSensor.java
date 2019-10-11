package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private ArrayList<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }

    public boolean isOn() {
        for (Sensor sens : sensors) {
            if (!sens.isOn()) {
                return false;
            }
        }
        return true;
    }

    public void on() {
        for (Sensor sens : sensors) {
            sens.on();
        }
    }

    public void off() {
        for (Sensor sens : sensors) {
            sens.off();
        }
    }

    public int measure() {
        if (!this.isOn() || this.sensors.size() == 0) {
            throw new IllegalStateException("sensors are off or the list is empty");
        }
        int sumOfTemperatures = 0;
        for (Sensor sens : sensors) {
            sumOfTemperatures +=sens.measure();
        }
        sumOfTemperatures /= this.sensors.size();
        this.readings.add(sumOfTemperatures);
        return sumOfTemperatures;
    }

    public void addSensor(Sensor additional) {
        this.sensors.add(additional);
    }

    public List<Integer> readings() {
        return readings;
    }
}
