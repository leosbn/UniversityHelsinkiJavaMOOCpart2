
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Printer {

    private Scanner reader;
    private File file;
    private ArrayList<String> lines;

    public Printer(String fileName) throws Exception {
        this.file = new File(fileName);
        this.reader = new Scanner(file, "UTF-8");
        this.lines = new ArrayList<String>();
    }

    public void printLinesWhichContain(String word) {
        while (this.reader.hasNextLine()) {
            this.lines.add(reader.nextLine());
        }
        for(String line : this.lines){
            if(line.contains(word)){
                System.out.println(line);
            }
        }
    }
}
