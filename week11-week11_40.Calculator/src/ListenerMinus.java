
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ListenerMinus implements ActionListener {

    private JButton buttonMinus;
    private JTextField textOutput;
    private JTextField textInput;
    private Calculations calc;
    private JButton res;

    public ListenerMinus(JButton minus, JTextField output, JTextField input, Calculations calc, JButton res) {
        this.buttonMinus = minus;
        this.textOutput = output;
        this.textInput = input;
        this.calc = calc;
        this.res = res;
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            if (!this.textInput.getText().equals("")) {
                this.textOutput.setText(this.calc.operationSubtract(this.textInput.getText()));
            }
            this.textInput.setText("");
            this.res.setEnabled(true);
        } catch (NumberFormatException e) {
            this.textInput.setText("");
        }
    }
}
