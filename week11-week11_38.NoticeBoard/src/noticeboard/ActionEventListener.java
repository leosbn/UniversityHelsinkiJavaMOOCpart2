package noticeboard;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ActionEventListener implements ActionListener {

    private JTextField toBeCopied;
    private JLabel copySupport;

    public ActionEventListener(JTextField toGive, JLabel toReceive) {
        this.toBeCopied=toGive;
        this.copySupport=toReceive;
    }
    
    public void actionPerformed(ActionEvent ae){
        this.copySupport.setText(this.toBeCopied.getText());
        this.toBeCopied.setText("");
    }
}
