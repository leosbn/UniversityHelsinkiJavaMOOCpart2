
public class Address {
    private String street;
    private String city;
    
    public Address(String street, String city){
        this.street=street;
        this.city=city;
    }
    
    public Address(){
        this("", "");
    }
    
    public String getStreet(){
        return this.street;
    }
    
    public String getCity(){
        return this.city;
    }
    
    public void addStreet(String street){
        this.street=street;
    }
    
    public void addCity(String city){
        this.city=city;
    }
    
    public void remove(){
        this.street="";
        this.city="";
    }
}
