package farmsimulator;

public class BulkTank {

    private double capacity;
    private double volume;

    public BulkTank() {
        this.capacity = 2000;
        this.volume = 0;
    }

    public BulkTank(double capacity) {
        this.capacity = capacity;
        this.volume = 0;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getVolume() {
        return this.volume;
    }

    public double howMuchFreeSpace() {
        return this.getCapacity() - this.getVolume();
    }
    
    public void addToTank(double amount){
        if(amount<=this.howMuchFreeSpace()){
            this.volume+=amount;
        } else {
            this.volume+=this.howMuchFreeSpace();
        }
    }
    
    public double getFromTank(double amount){
        if(amount<=this.volume){
            this.volume-=amount;
        } else {
            this.volume=0;
        }
        return amount;
    }
    
    public String toString(){
        return Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }
}
