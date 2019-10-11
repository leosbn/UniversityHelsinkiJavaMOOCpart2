package personnel;

public class Main {

    public static void main(String[] args) {
        // write test code here
        Employees t = new Employees();
        Person h = new Person("Arto", Education.D);
        t.add(h);
        t.add(new Person("Jon", Education.GRAD));
        t.add(new Person("Karl", Education.B));
        t.add(new Person("Don", Education.M));
        t.print(Education.B);
        //t.print();
        
        //Person arto = new Person("Arto", Education.D);
        //System.out.println(arto);
    }
}
