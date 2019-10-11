package dictionary;

import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;

public class MindfulDictionary {

    private Map<String, String> dictionary;
    private Map<String, String> revDict;
    private File file;

    public MindfulDictionary() {
        this.dictionary = new HashMap<String, String>();
        this.revDict = new HashMap<String, String>();
    }

    public MindfulDictionary(String file) {
        this();
        this.file = new File(file);
    }

    public void add(String word, String translation) {
        if (!this.dictionary.containsKey(word)) {
            this.dictionary.put(word, translation);
            this.revDict.put(translation, word);
        }
    }

    public String translate(String word) {
        if (this.dictionary.containsKey(word)) {
            return this.dictionary.get(word);
        } else if (this.revDict.containsKey(word)) {
            return this.revDict.get(word);
        }
        return null;
    }

    public void remove(String word) {
        if (this.dictionary.containsKey(word)) {
            this.revDict.remove(this.dictionary.get(word));
            this.dictionary.remove(word);
        } else if (this.revDict.containsKey(word)) {
            this.dictionary.remove(this.revDict.get(word));
            this.revDict.remove(word);
        }
    }

    public boolean load() {
        try {
            Scanner reader = new Scanner(this.file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean save() {
        try {
            FileWriter writer = new FileWriter(this.file);
            for (String key : this.dictionary.keySet()) {
                writer.write(key + ":" + this.dictionary.get(key) + "\n");
            }
            writer.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
