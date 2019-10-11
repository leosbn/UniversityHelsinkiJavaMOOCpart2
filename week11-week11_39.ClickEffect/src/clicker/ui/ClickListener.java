package clicker.ui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import clicker.applicationlogic.*;

public class ClickListener implements ActionListener {

    private JLabel label;
    private Calculator calc;

    public ClickListener(Calculator calculator, JLabel text) {
        this.label = text;
        this.calc = calculator;
    }
    
    public void actionPerformed(ActionEvent ae){
        this.calc.increase();
        this.label.setText(Integer.toString(this.calc.giveValue()));
    }
}
