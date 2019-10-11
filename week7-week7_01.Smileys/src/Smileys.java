
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Mikael");
        // printWithSmileys("Beerbottle");
        // printWithSmileys("Interface");
    }

    private static void printWithSmileys(String characterString) {
        printHeaderFooter(characterString);
        printCentral(characterString);
        printHeaderFooter(characterString);

    }

    public static void printHeaderFooter(String characterString) {
        /*
        int numberOfSmileys = characterString.length();
        System.out.print(":)");
        if (numberOfSmileys % 2 == 1) {
            numberOfSmileys++;
        }
        for (int i = 0; i < numberOfSmileys; i++) {
            System.out.print(":)");
        }
        System.out.println("");
         */
        System.out.print(":)");
        if (characterString.length() % 2 == 1) {
            for (int i = 0; i < ((characterString.length() + 2) / 2) + 1; i++) {
                System.out.print(":)");
            }
        } else {
            for (int i = 0; i < ((characterString.length() + 2) / 2); i++) {
                System.out.print(":)");
            }
        }
        System.out.print(":)");
        System.out.println("");
    }

    public static void printCentral(String characterString) {
        String centralPrint = characterString;
        if (characterString.length() % 2 == 1) {
            System.out.println(":) " + centralPrint + "  :)");
        } else {
            System.out.println(":) " + centralPrint + " :)");
        }
    }
}
