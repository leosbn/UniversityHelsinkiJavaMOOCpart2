package farmsimulator;

import java.util.Random;

public class Cow implements Milkable, Alive {

    private String name;
    private int udder;
    private double volume;
    private static final String[] NAMES = new String[]{"Anu", "Arpa", "Essi", "Heluna", "Hely", "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo", "Jaana", "Jami", "Jatta", "Laku", "Liekki", "Mainikki", "Mella", "Mimmi", "Naatti", "Nina", "Nyytti", "Papu", "Pullukka", "Pulu", "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow() {
        this.name = NAMES[new Random().nextInt(NAMES.length)];
        this.udder = 15 + new Random().nextInt(26);
        this.volume = 0;
    }

    public Cow(String name) {
        this.name = name;
        this.udder = 15 + new Random().nextInt(26);
        this.volume = 0;
    }

    public String getName() {
        return this.name;
    }

    public double getCapacity() {
        return this.udder;
    }

    public double getAmount() {
        return this.volume;
    }

    public String toString() {
        return this.getName() + " " + Math.ceil(this.getAmount()) + "/" + this.getCapacity();
    }

    public double milk() {
        double milkTransferred = this.volume;
        this.volume = 0;
        return milkTransferred;
    }

    public void liveHour() {
        if (this.getAmount() < this.getCapacity()) {
            this.volume += 0.7 + new Random().nextInt(1)*1.3;
        }
        if (this.volume > this.getCapacity()) {
            this.volume = this.getCapacity();
        }
    }

}
