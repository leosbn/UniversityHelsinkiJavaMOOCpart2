public class Main {
    public static void main(String[] args) {
        // Test your program here
        Changer o = new Changer();
        o.addChange(new Change('A','I'));
        o.addChange(new Change('!','?'));
        o.addChange(new Change('e','a'));
        System.out.println(o.change("Architect!"));
    }
}
