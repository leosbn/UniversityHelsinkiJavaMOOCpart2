package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.gui.Updatable;
import wormgame.domain.*;
import java.util.Random;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
        this.worm = new Worm(this.width / 2, this.height / 2, Direction.DOWN);
        addActionListener(this);
        setInitialDelay(2000);
        int appleX = new Random().nextInt(this.getWidth());
        int appleY = new Random().nextInt(this.getHeight());
        for (int i = 0; i < this.worm.getLength(); i++) {
            if (appleX != this.worm.getPieces().get(i).getX() && appleY != this.worm.getPieces().get(i).getY() && appleX >= 0 && appleY >= 0) {
                this.apple = new Apple(appleX, appleY);
            } else {
                this.apple = new Apple(appleX/2 + 1, appleY/2 + 1);
            }
        }
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
        this.worm.move();
        if (this.worm.runsInto(this.apple)) {
            this.worm.grow();
            this.apple = new Apple(new Random().nextInt(this.width), new Random().nextInt(this.height));
        }
        if (this.worm.runsIntoItself()) {
            this.continues = false;
        } else if (this.worm.getHead().getX() == this.width || this.worm.getHead().getX() < 0) {
            this.continues = false;
        } else if (this.worm.getHead().getY() == this.height || this.worm.getHead().getY() < 0) {
            this.continues = false;
        }
        this.updatable.update();
        this.setDelay(1000 / this.worm.getLength());
    }

    public Worm getWorm() {
        return this.worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return this.apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

}
