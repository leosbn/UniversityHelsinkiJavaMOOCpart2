package reader.criteria;

public class EndsWithQuestionOrExclamationMark implements Criterion {

    String line;

    public boolean complies(String string) {
        if (string.isEmpty()) {
            return false;
        }
        return string.charAt(string.length() - 1) == '!' || string.charAt(string.length() - 1) == '?';
    }
}
