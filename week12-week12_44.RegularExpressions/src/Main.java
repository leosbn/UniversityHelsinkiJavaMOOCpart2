
public class Main {

    public static void main(String[] args) {
        // write test code here
        System.out.println(clockTime("24:37:01"));
    }

    public static boolean isAWeekDay(String string) {
        if (string.matches("mon|tue|wed|thu|fri|sat|sun")) {
            return true;
        }
        return false;
    }

    public static boolean allVowels(String string) {
        if (string.matches("(a|e|i|o|u|ä|ö)*")) {
            return true;
        }
        return false;
    }

    public static boolean clockTime(String string) {
        try {
            if (Integer.parseInt(string.substring(0, 2)) > 23) {
                return false;
            }
            if (string.matches("[0-9][0-9]:[0-5][0-9]:[0-5][0-9]")) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
