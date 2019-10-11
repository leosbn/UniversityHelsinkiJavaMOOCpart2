
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        File fileToRead = new File(file);
        Scanner reader = new Scanner(fileToRead);
        ArrayList<String> allText = new ArrayList<String>();
        while (reader.hasNextLine()) {
            allText.add(reader.nextLine());
        }
        return allText;
    }

    public void save(String file, String text) throws IOException {
        FileWriter fileToWrite = new FileWriter(file);
        fileToWrite.write(text);
        fileToWrite.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter fileTo = new FileWriter(file);
        for(String line : texts){
            fileTo.write(line + "\n");
        }
        fileTo.close();
    }
}
