package reference;

import java.util.Collections;
import reference.comparator.*;
import reference.domain.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Reference {

    private RatingRegister register;

    public Reference(RatingRegister register) {
        this.register = register;
    }

    public Film recommendFilm(Person person) {
        if (this.register.getPersonalRatings(person).isEmpty()) {
            List<Film> movies = new ArrayList<Film>(this.register.filmRatings().keySet());
            Collections.sort(movies, new FilmComparator(this.register.filmRatings()));
            return movies.get(0);
        }
        return getRecommendation(person, sortPersonsBySimilarity(person));
    }

    public Map<Person, Integer> similarity(Map<Film, Rating> filmRatings) {
        Map<Person, Integer> similarityOfPersons = new HashMap<Person, Integer>();
        for (Person person : this.register.reviewers()) {
            int similarityIndex = 0;
            for (Film film : this.register.getPersonalRatings(person).keySet()) {
                for (Rating rating : this.register.getRatings(film)) {
                    similarityIndex += rating.getValue() * this.register.getRating(person, film).getValue();
                }
            }
            if (similarityIndex > 0) {
                similarityOfPersons.put(person, similarityIndex);
            }
        }
        return similarityOfPersons;
    }

    public List<Person> sortPersonsBySimilarity(Person person) {
        Map<Person, Integer> reviewerSimilarity = similarity(this.register.getPersonalRatings(person));
        List<Person> similarReviewers = new ArrayList<Person>(reviewerSimilarity.keySet());
        Collections.sort(similarReviewers, new PersonComparator(reviewerSimilarity));
        return similarReviewers;
    }

    public Film getRecommendation(Person person, List<Person> sortPersonsSimilarity) {
        for (Person author : sortPersonsSimilarity) {
            if (person == author) {
                continue;
            }
            for (Film film : this.register.getPersonalRatings(author).keySet()) {
                if (this.register.getPersonalRatings(person).containsKey(film)) {
                    continue;
                } if (this.register.getPersonalRatings(author).get(film).getValue() >= 3) {
                    return film;
                }
            }
        }
        return null;
    }
}
