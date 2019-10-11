
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        FileManager t = new FileManager();

        for (String line : t.read("src/testinput1.txt")) {
            System.out.println(line);
        }

        t.save("src/testinput3.txt", "test");
        ArrayList<String> words = new ArrayList<String>();
        words.add("wat");
        words.add("this is a test");
        words.add("words");
        System.out.println(words);
        t.save("src/testinput4.txt", words);
    }
}
