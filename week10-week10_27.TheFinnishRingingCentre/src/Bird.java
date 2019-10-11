
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }


    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }

    @Override
    public int hashCode() {
        return this.latinName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Bird other = (Bird) obj;
        if (this.ringingYear != other.ringingYear) {
            return false;
        }
        if ((this.latinName == null) ? (other.latinName != null) : !this.latinName.equals(other.latinName)) {
            return false;
        }
        return true;
    }
    
    
}


