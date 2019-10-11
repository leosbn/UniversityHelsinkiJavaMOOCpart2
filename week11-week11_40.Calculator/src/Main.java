

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Calculations ca = new Calculations();
        SwingUtilities.invokeLater(new GraphicCalculator(ca));
    }
}
