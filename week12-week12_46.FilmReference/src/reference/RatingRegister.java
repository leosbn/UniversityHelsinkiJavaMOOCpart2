package reference;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import reference.domain.*;

public class RatingRegister {

    private Map<Film, List<Rating>> generalRatings;
    private Map<Person, Map<Film, Rating>> personRatings;

    public RatingRegister() {
        this.generalRatings = new HashMap<Film, List<Rating>>();
        this.personRatings = new HashMap<Person, Map<Film, Rating>>();
    }

    /**
     * add a rating for a movie
     *
     * @param film
     * @param rating
     */
    public void addRating(Film film, Rating rating) {
        if (this.generalRatings.containsKey(film)) {
            this.generalRatings.get(film).add(rating);
        } else {
            this.generalRatings.put(film, new ArrayList<Rating>());
            this.generalRatings.get(film).add(rating);
        }
    }

    /**
     * add a rating for a movie, given by a single user
     *
     * @param person
     * @param film
     * @param rating
     */
    public void addRating(Person person, Film film, Rating rating) {
        if (this.personRatings.containsKey(person)) {
            this.personRatings.get(person).put(film, rating);
            this.addRating(film, rating);
        } else {
            this.personRatings.put(person, new HashMap<Film, Rating>());
            this.personRatings.get(person).put(film, rating);
            this.addRating(film, rating);
        }
    }

    /**
     * get all ratings for a specific movie
     *
     * @param film
     * @return
     */
    public List<Rating> getRatings(Film film) {
        if (!this.generalRatings.containsKey(film)) {
            return null;
        }
        return this.generalRatings.get(film);
    }

    /**
     * if the specified person has rated the specified movie, get the rating
     *
     * @param person
     * @param film
     * @return
     */
    public Rating getRating(Person person, Film film) {
        if (this.personRatings.containsKey(person)) {
            if (this.personRatings.get(person).containsKey(film)) {
                return this.personRatings.get(person).get(film);
            } else {
                this.personRatings.get(person).put(film, Rating.NOT_WATCHED);
            }
        } else {
            this.personRatings.put(person, new HashMap<Film, Rating>());
            this.personRatings.get(person).put(film, Rating.NOT_WATCHED);
        }
        return this.personRatings.get(person).get(film);
    }

    /**
     * a map of all movies, each of them with its own ratings
     *
     * @return
     */
    public Map<Film, List<Rating>> filmRatings() {
        return this.generalRatings;
    }

    /**
     * a map of the ratings given by the specified person to movies
     *
     * @param person
     * @return
     */
    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (this.personRatings.containsKey(person)) {
            return this.personRatings.get(person);
        } else {
            this.personRatings.put(person, new HashMap<Film, Rating>());
        }
        return this.personRatings.get(person);
    }

    /**
     * list of all people who left a review about a film
     *
     * @return
     */
    public List<Person> reviewers() {
        ArrayList<Person> reviewers = new ArrayList<Person>();
        for (Person person : this.personRatings.keySet()) {
            reviewers.add(person);
        }
        return reviewers;
    }
}
