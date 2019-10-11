package movingfigure;

import java.util.List;
import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.*;

public class CompoundFigure extends Figure {

    private List<Figure> figures;

    public CompoundFigure() {
        this.figures = new ArrayList<Figure>();
    }
    
    public void add(Figure f){
        this.figures.add(f);
    }
    
    public void move(int dx, int dy){
        for(Figure fig : this.figures){
            fig.move(dx, dy);
        }
    }
    
    public void draw(Graphics graphics){
        for(Figure fig : this.figures){
            fig.draw(graphics);
        }
    }
}
