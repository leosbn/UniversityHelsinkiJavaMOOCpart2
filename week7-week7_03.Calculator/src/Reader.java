import java.util.Scanner;

public class Reader {
    private Scanner scan;
    
    public Reader(){
        this.scan=new Scanner(System.in);
    }
    
    public String readString(){
        return this.scan.nextLine();
    }
    
    public int readInteger(){
        String convert =this.scan.nextLine();
        return Integer.parseInt(convert);
    }
    
}
