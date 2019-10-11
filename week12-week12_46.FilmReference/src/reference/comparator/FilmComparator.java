package reference.comparator;

import reference.domain.*;
import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class FilmComparator implements Comparator<Film> {

    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int compare(Film o1, Film o2) {
        int avg1=0;
        ArrayList<Rating> ratings1 = new ArrayList<Rating>();
        int avg2=0;
        ArrayList<Rating> ratings2 = new ArrayList<Rating>();
        if (this.ratings.containsKey(o1) && this.ratings.containsKey(o2)) {
            for (Rating rat : this.ratings.get(o1)) {
                ratings1.add(rat);
            }
            for (Rating rati : this.ratings.get(o2)) {
                ratings2.add(rati);
            }
        }
        for(Rating rat1 : ratings1){
            avg1+=rat1.getValue();
        }
        for(Rating rat2:ratings2){
            avg2+=rat2.getValue();
        }
        
        return (avg2/ratings2.size())-(avg1/ratings1.size());
    }
}
