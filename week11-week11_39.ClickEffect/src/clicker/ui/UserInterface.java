package clicker.ui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import clicker.applicationlogic.*;
import java.awt.BorderLayout;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calcLogic;

public UserInterface(){
    this.calcLogic=new PersonalCalculator();
}
    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);
        JLabel label = new JLabel(Integer.toString(this.calcLogic.giveValue()));
        JButton button = new JButton("Click!");
        button.addActionListener(new ClickListener(this.calcLogic, label));
        container.add(label, BorderLayout.WEST);
        container.add(button, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }
}
