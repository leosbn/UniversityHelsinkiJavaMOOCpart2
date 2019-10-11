package reference.comparator;

import reference.domain.*;
import java.util.Comparator;
import java.util.Map;

public class PersonComparator implements Comparator<Person> {

    private Map<Person, Integer> peopleIdentities;

    public PersonComparator(Map<Person, Integer> peopleIdentities) {
        this.peopleIdentities = peopleIdentities;
    }

    @Override
    public int compare(Person o1, Person o2) {
        int number=1000;
        if(this.peopleIdentities.containsKey(o1)&&this.peopleIdentities.containsKey(o2)){
            number = this.peopleIdentities.get(o2) - this.peopleIdentities.get(o1);
        }
        return number;
    }
}
