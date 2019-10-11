
import java.awt.Container;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.WindowConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

public class GraphicCalculator implements Runnable {

    private JFrame frame;
    private Calculations calc;

    public GraphicCalculator(Calculations calc) {
        this.calc = calc;
    }

    @Override
    public void run() {
        this.frame = new JFrame("Calculator");
        this.frame.setPreferredSize(new Dimension(400, 200));
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(this.frame.getContentPane());
        this.frame.pack();
        this.frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout frameLayout = new GridLayout(3, 1);
        container.setLayout(frameLayout);
        JTextField upperTextField = new JTextField("0");
        upperTextField.setEnabled(false);
        JTextField lowerTextField = new JTextField();
        
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 3));
        JButton operationPlus = new JButton("+");
        JButton operationMinus = new JButton("-");
        JButton operationReset = new JButton("Z");
        operationReset.setEnabled(false);
        
        ListenerPlus sum = new ListenerPlus(operationPlus, upperTextField, lowerTextField, this.calc, operationReset);
        ListenerMinus sub = new ListenerMinus(operationMinus, upperTextField, lowerTextField, this.calc, operationMinus);
        ListenerReset res = new ListenerReset(operationReset, upperTextField, lowerTextField, this.calc);
        //ListenerTotal textTotal = new ListenerTotal(upperTextField, operationReset, this.calc);

        operationPlus.addActionListener(sum);
        operationMinus.addActionListener(sub);
        operationReset.addActionListener(res);
        //upperTextField.addActionListener(textTotal);

        container.add(upperTextField);
        container.add(lowerTextField);
        container.add(buttonsPanel);
        buttonsPanel.add(operationPlus);
        buttonsPanel.add(operationMinus);
        buttonsPanel.add(operationReset);
    }

    public JFrame getFrame() {
        return frame;
    }
}
