package reader.criteria;

public class AllLines implements Criterion {

    String line;

    public boolean complies(String line) {
        return true;
    }
}
