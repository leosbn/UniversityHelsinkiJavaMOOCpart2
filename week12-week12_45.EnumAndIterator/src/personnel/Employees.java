package personnel;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Employees {

    private List<Person> employees;

    public Employees() {
        this.employees = new ArrayList<Person>();
    }

    public void add(Person person) {
        this.employees.add(person);
    }

    public void add(List<Person> persons) {
        this.employees.addAll(persons);
    }

    public void print() {
        Iterator<Person> iterator = this.employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void print(Education education) {
        Iterator<Person> iterator = this.employees.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if(person.getEducation()==education){
                System.out.println(person);
            }
        }
    }
    
    public void fire(Education education){
        Iterator<Person> iterator = this.employees.iterator();
        while(iterator.hasNext()){
            Person person = iterator.next();
            if(person.getEducation()==education){
                iterator.remove();
            }
        }
    }
}
