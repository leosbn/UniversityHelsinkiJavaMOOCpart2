
package reader.criteria;

public class AtLeastOne implements Criterion {
    private Criterion[] criterion;
    
    public AtLeastOne(Criterion... criterion){
        this.criterion=criterion;
    }
    
    public boolean complies(String string){
        for(int i=0;i<this.criterion.length;i++){
            if(criterion[i].complies(string)){
                return true;
            }
        }
        return false;
    }
}
