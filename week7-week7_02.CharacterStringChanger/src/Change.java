
public class Change {
    private char char1;
    private char char2;
    
    public Change(char fromCharacter, char toCharacter){
        this.char1=fromCharacter;
        this.char2=toCharacter;
    }
    
    public String change(String characterString){
        return characterString.replace(getChar1(), getChar2());
    }
    
    public char getChar1(){
        return this.char1;
    }
    
    public char getChar2(){
        return this.char2;
    }
    
    
}
