
package reader.criteria;

public class LengthAtLeast implements Criterion {
    int length;
    public LengthAtLeast(int length){
        this.length=length;
    }
    
    public boolean complies(String string){
        return string.length()>=this.length;
    }
}
