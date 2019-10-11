package tools;

import java.util.Set;
import java.util.HashSet;

public class PersonalDuplicateRemover implements DuplicateRemover {

    private int numberOfDetectedDuplicates;
    private Set<String> characterStrings;

    public PersonalDuplicateRemover() {
        this.characterStrings = new HashSet<String>();
        this.numberOfDetectedDuplicates = 0;
    }

    public void add(String characterString) {
        if (this.characterStrings.contains(characterString)) {
            this.increaseDetectedDuplicates();
        }
        this.characterStrings.add(characterString);
    }

    public void increaseDetectedDuplicates() {
        this.numberOfDetectedDuplicates++;
    }

    public int getNumberOfDetectedDuplicates() {
        return this.numberOfDetectedDuplicates;
    }

    public Set<String> getUniqueCharacterStrings() {
        return this.characterStrings;
    }

    public void empty() {
        this.characterStrings.clear();
        this.numberOfDetectedDuplicates = 0;
    }
}
