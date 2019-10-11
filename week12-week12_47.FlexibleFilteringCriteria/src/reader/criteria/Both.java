package reader.criteria;

public class Both implements Criterion {

    private Criterion marks;
    private Criterion containsWords;

    public Both(Criterion criterion1, Criterion criterion2) {
        this.marks = criterion1;
        this.containsWords = criterion2;
    }

    public boolean complies(String string) {
        if(this.marks.complies(string)&&this.containsWords.complies(string)){
            return true;
        }
        return false;
    }
}
