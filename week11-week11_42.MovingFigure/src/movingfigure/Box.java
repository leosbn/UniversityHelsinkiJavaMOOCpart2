package movingfigure;

import java.awt.Graphics;

public class Box extends Figure{

    private int length;
    private int height;

    public Box(int x, int y, int length, int height) {
        super(x, y);
        this.length=length;
        this.height=height;
    }
    
    public void draw(Graphics graphics){
        graphics.fillRect(super.getX(), super.getY(), length, height);
    }
}
