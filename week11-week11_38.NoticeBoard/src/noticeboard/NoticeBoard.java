package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        this.frame=new JFrame();
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setPreferredSize(new Dimension(400, 200));
        createComponents(this.frame.getContentPane());
        this.frame.pack();
        this.frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        JTextField textArea = new JTextField();
        JButton button = new JButton("Copy!");
        JLabel label = new JLabel();
        ActionEventListener eventForButton = new ActionEventListener(textArea, label);
        button.addActionListener(eventForButton);
        
        container.add(textArea);
        container.add(button);
        container.add(label);
    }
}
