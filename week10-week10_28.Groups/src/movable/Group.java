package movable;

import java.util.List;
import java.util.ArrayList;

public class Group implements Movable {

    private List<Movable> list;

    public Group() {
        this.list=new ArrayList<Movable>();
    }
    
    public String toString(){
        String objects="";
        for (Movable obj : this.list){
            objects+=obj.toString()+"\n";
        }
        return objects;
    }
    
    public void addToGroup(Movable movable){
        this.list.add(movable);
    }

    public void move(int dx, int dy){
        for(Movable obj : this.list){
            obj.move(dx, dy);
        }
    }
}
