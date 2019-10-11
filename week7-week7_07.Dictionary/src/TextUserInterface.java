
import java.util.Scanner;

public class TextUserInterface {

    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {

        while (true) {
            System.out.println("Statement:");
            System.out.println("quit - quit the text user interface");
            String command = reader.nextLine();
            if (command.equals("quit")) {
                System.out.println("Cheers!");
                break;
            } else if (command.equals("add")) {
                add();
            } else if (command.equals("translate")) {
                translate();
            } else {
                System.out.println("Unknown statement");
            }
        }
    }

    public void add() {
        System.out.println("In Finnish: ");
        String wordF = reader.nextLine();
        System.out.println("Translation: ");
        String wordT = reader.nextLine();
        this.dictionary.add(wordF, wordT);
    }

    public void translate() {
        System.out.println("Give a word: ");
        String word = reader.nextLine();
        System.out.println("Translation: " + this.dictionary.translate(word));
    }

}
