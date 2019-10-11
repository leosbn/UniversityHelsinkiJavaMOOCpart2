package file;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Analysis {

    private ArrayList<String> linesOfText;
    private Scanner reader;

    public Analysis(File file) throws Exception {
        this.linesOfText = new ArrayList<String>();
        this.reader = new Scanner(file);
        while (reader.hasNextLine()) {
            this.linesOfText.add(reader.nextLine());
        }
    }

    public int lines() {
        return this.linesOfText.size();
    }

    public int characters() {
        ArrayList<Character> characters = new ArrayList<Character>();
        int numberOfChars = 0;
        for (String line : this.linesOfText) {
            numberOfChars += line.length() + 1;
        }
        return numberOfChars;
    }
}
