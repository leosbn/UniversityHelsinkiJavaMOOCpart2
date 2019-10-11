package wordinspection;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class WordInspection {

    private Scanner scanner;
    private ArrayList<String> list;

    public WordInspection(File file) throws Exception {
        this.list = new ArrayList<String>();
        this.scanner = new Scanner(file, "UTF-8");

        while (this.scanner.hasNextLine()) {
            this.list.add(this.scanner.nextLine());
        }
    }

    public int wordCount() {
        return this.list.size();
    }

    public List<String> wordsContainingZ() {
        List<String> wordsWithZ = new ArrayList<String>();
        for (String line : this.list) {
            if (line.contains("z")) {
                wordsWithZ.add(line);
            }
        }
        return wordsWithZ;
    }

    public List<String> wordsEndingInL() {
        List<String> wordsEndL = new ArrayList<String>();
        for (String line : this.list) {
            if (line.endsWith("l")) {
                wordsEndL.add(line);
            }
        }
        return wordsEndL;
    }

    public List<String> palindromes() {
        List<String> palindro = new ArrayList<String>();
        for (String line : this.list) {
            char[] word = new char[line.length()];
            String palWord = "";
            for (int i = 0; i < line.length(); i++) {
                word[i] = line.charAt(line.length() - 1 - i);
                palWord += word[i];
            }
            if (line.equals(palWord)) {
                palindro.add(line);
            }
        }
        return palindro;
    }
    
    public List<String> wordsWhichContainAllVowels(){
        List<String> allVow = new ArrayList<String>();
        for(String line : this.list){
            if(line.contains("a")&&line.contains("e")&&line.contains("i")&&line.contains("o")&&line.contains("u")&&line.contains("y")&&line.contains("ä")&&line.contains("ö")){
                allVow.add(line);
            }
        }
        return allVow;
    }
}
