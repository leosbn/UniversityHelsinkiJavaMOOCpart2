package dictionary;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {

    private Map<String, Set<String>> dictionary;

    public PersonalMultipleEntryDictionary() {
        this.dictionary = new HashMap<String, Set<String>>();
    }

    public void add(String word, String entry) {
        if (!this.dictionary.containsKey(word)) {
            this.dictionary.put(word, new HashSet<String>());
        }
        Set<String> translations = this.dictionary.get(word);
        translations.add(entry);
    }

    public Set<String> translate(String word) {
        
        if (!this.dictionary.containsKey(word)) {
            return null;
        }
        Set<String> listOfTranslations = this.dictionary.get(word);
        return listOfTranslations;
    }

    public void remove(String word) {
        this.dictionary.remove(word);
    }
}
