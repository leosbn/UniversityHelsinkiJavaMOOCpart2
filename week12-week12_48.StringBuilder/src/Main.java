
public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(build(t));
    }

    public static String build(int[] t) {
        StringBuilder text = new StringBuilder();
        text.append("{");
        for (int i = 0; i < t.length; i++) {
            if (i % 4 == 0) {
                text.append("\n ");
            }
            text.append(t[i]);
            if (i < t.length - 1) {
                text.append(", ");
            }
        }
        text.append("\n} ");
        return text.toString();
    }
}
