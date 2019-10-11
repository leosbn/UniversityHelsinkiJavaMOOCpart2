
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ListenerReset implements ActionListener {

    private JButton buttonReset;
    private JTextField textOutput;
    private JTextField textInput;
    private Calculations calc;

    public ListenerReset(JButton reset, JTextField output, JTextField input, Calculations calc) {
        this.buttonReset = reset;
        this.textOutput = output;
        this.textInput = input;
        this.calc = calc;
    }

    public void actionPerformed(ActionEvent ae) {
        this.textOutput.setText(this.calc.reset());
        this.buttonReset.setEnabled(false);
        this.textInput.setText("");
    }
}
