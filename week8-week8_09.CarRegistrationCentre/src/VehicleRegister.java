
import java.util.HashMap;
import java.util.ArrayList;

public class VehicleRegister {

    private HashMap<RegistrationPlate, String> owners;

    public VehicleRegister() {
        this.owners = new HashMap<RegistrationPlate, String>();
    }

    public boolean add(RegistrationPlate plate, String owner) {
        if (owners.get(plate) == null) {
            owners.put(plate, owner);
            return true;
        }
        return false;
    }

    public String get(RegistrationPlate plate) {
        if (owners.containsKey(plate)) {
            return owners.get(plate);
        } else {
            return null;
        }
    }

    public boolean delete(RegistrationPlate plate) {
        if (owners.containsKey(plate)) {
            owners.remove(plate);
            return true;
        } else {
            return false;
        }
    }

    public void printRegistrationPlates() {
        for (RegistrationPlate plate : owners.keySet()) {
            System.out.println(plate);
        }
    }

    public void printOwners(){
        ArrayList<String> ownersList = new ArrayList<String>();
        for(RegistrationPlate plate: owners.keySet()){
            String name=owners.get(plate);
            if (!ownersList.contains(name)){
                ownersList.add(name);
            }
        }
        for(String names : ownersList){
            System.out.println(names);
        }
        
    }
}
