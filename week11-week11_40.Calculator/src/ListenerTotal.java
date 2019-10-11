
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ListenerTotal implements ActionListener {

    private JTextField total;
    private JButton button;
    private Calculations calc;

    public ListenerTotal(JTextField total, JButton button, Calculations calc) {
        this.total = total;
        this.button = button;
        this.calc = calc;
    }

    public void actionPerformed(ActionEvent ae) {
        if (!this.total.getText().contains("0")) {
            this.button.setEnabled(true);
        } else {
            this.button.setEnabled(false);
        }
    }
}
