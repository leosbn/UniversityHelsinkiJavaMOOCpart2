
package reader.criteria;

public class Not implements Criterion {
    private Criterion criterion1;
    
    public Not(Criterion criterion){
        this.criterion1=criterion;
    }
    
    public boolean complies(String string){
        if(this.criterion1.complies(string)){
            return false;
        }
        return true;
    }
}
