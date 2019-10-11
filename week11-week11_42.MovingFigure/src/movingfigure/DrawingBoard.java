package movingfigure;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;

public class DrawingBoard extends JPanel {

    private Figure figure;

    public DrawingBoard(Figure figure) {
        super.setBackground(Color.white);
        this.figure = figure;
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        figure.draw(graphics);
    }
}
