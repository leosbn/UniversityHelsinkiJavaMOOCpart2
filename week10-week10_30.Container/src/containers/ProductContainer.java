
package containers;

public class ProductContainer extends Container {
    private String content;
    
    public ProductContainer(String productName, double capacity){
        super(capacity);
        this.content=productName;
    }
    
    public String getName(){
        return this.content;
    }
    
    public void setName(String newName){
        this.content=newName;
    }
    
    public String toString(){
        return this.getName() + ": " + super.toString();
    }
}
