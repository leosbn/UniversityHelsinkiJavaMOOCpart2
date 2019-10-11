import java.util.HashMap;
import java.util.ArrayList;

public class Dictionary {
    private HashMap<String, String> vocab;
    
    public Dictionary(){
        this.vocab=new HashMap<String, String>();
    }
    
    public String translate(String word){
        if(this.vocab.containsKey(word)){
            return this.vocab.get(word);
        }
        return null;
    }
    
    public void add(String word, String translation){
        this.vocab.put(word, translation);
    }
    
    public int amountOfWords(){
        return this.vocab.size();
    }
    
    public ArrayList<String> translationList(){
        ArrayList<String> translations = new ArrayList<String>();
        for (String translation : this.vocab.keySet()){
            translations.add(translation + " = " + this.vocab.get(translation));
        }
        return translations;
    }
}
