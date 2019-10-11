package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        // Create your app here
        JFrame frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(300, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        BoxLayout disposition = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(disposition);
        JLabel areYou = new JLabel("Are you?");
        ButtonGroup checkBoxes = new ButtonGroup();
        JCheckBox yes = new JCheckBox("Yes!");
        JCheckBox no = new JCheckBox("No!");
        checkBoxes.add(yes);
        checkBoxes.add(no);
        JLabel reason = new JLabel("Why?");
        ButtonGroup radioButtons = new ButtonGroup();
        JRadioButton why1=new JRadioButton("No reason.");
        JRadioButton why2 = new JRadioButton("Because it is fun!");
        radioButtons.add(why1);
        radioButtons.add(why2);
        JButton done = new JButton("Done!");
        
        container.add(areYou);
        container.add(yes);
        container.add(no);
        container.add(reason);
        container.add(why1);
        container.add(why2);
        container.add(done);
    }

    public JFrame getFrame() {
        return frame;
    }
}
