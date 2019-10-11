package containers;

import java.util.ArrayList;

public class ContainerHistory {

    private ArrayList<Double> history;

    public ContainerHistory() {
        this.history = new ArrayList<Double>();
    }

    public void add(double situation) {
        this.history.add(situation);
    }

    public void reset() {
        this.history.clear();
    }

    public String toString() {
        return this.history.toString();
    }

    public double maxValue() {
        double maxVal = 0;
        if (this.history.size() > 0) {
            if (this.history.size() == 1) {
                return this.history.get(0);
            } else {
                for (double number : this.history) {
                    if (number > maxVal) {
                        maxVal = number;
                    }
                }
                return maxVal;
            }
        }
        return 0;
    }

    public double minValue() {
        double minVal = this.history.get(0);
        if (this.history.size() > 0) {
            if (this.history.size() == 1) {
                return this.history.get(0);
            } else {
                for (double number : this.history) {
                    if (number < minVal) {
                        minVal = number;
                    }
                }
                return minVal;
            }
        }
        return 0;
    }

    public double average() {
        double sum = 0;
        for (int i = 0; i < this.history.size(); i++) {
            sum += this.history.get(i);
        }
        return sum / this.history.size();
    }

    public double greatestFluctuation() {
        if (this.history.size() > 1) {
            double greatestFlux = Math.abs(this.history.get(0) - this.history.get(1));
            for (int i = 0; i < this.history.size() - 1; i++) {
                double compared = Math.abs(this.history.get(i) - this.history.get(i + 1));
                if (compared > greatestFlux) {
                    greatestFlux = compared;
                }
            }
            return Math.abs(greatestFlux);
        }
        return 0;
    }

    public double variance() {
        double numerator = 0;
        for (double number : this.history) {
            numerator += Math.pow((number - this.average()), 2);
        }
        return numerator / (this.history.size() - 1);
    }
}
