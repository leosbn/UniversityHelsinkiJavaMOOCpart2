package wormgame.gui;

import wormgame.domain.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import wormgame.Direction;

public class KeyboardListener implements KeyListener {
    
    private Worm worm;
    
    public KeyboardListener(Worm worm) {
        this.worm = worm;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.worm.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.worm.setDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.worm.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.worm.setDirection(Direction.RIGHT);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
