package wormgame.domain;

import wormgame.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Worm {

    private int originalX;
    private int originalY;
    private Direction originalDirection;
    private List<Piece> worm;
    private boolean grows;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.originalX = originalX;
        this.originalY = originalY;
        this.originalDirection = originalDirection;
        this.worm = new ArrayList<Piece>();
        this.worm.add(new Piece(this.originalX, this.originalY));
        this.grows = false;
    }

    public Direction getDirection() {
        return this.originalDirection;
    }

    public void setDirection(Direction dir) {
        this.originalDirection = dir;
    }

    public int getLength() {
        return this.worm.size();
    }

    public List<Piece> getPieces() {
        return this.worm;
    }

    public void move() {
        int newX = this.getHead().getX();
        int newY = this.getHead().getY();
        switch (this.originalDirection) {
            case LEFT:
                newX--;
                break;
            case RIGHT:
                newX++;
                break;
            case UP:
                newY--;
                break;
            case DOWN:
                newY++;
                break;
            default:
                break;
        }
        if (this.getLength() > 2 && !this.grows) {
            this.worm.remove(0);
        }
        if (this.grows) {
            this.grows = false;
        }
        this.worm.add(new Piece(newX, newY));
    }

    public void grow() {
        this.grows = true;
    }

    public boolean runsInto(Piece piece) {
        for(int i=0;i<this.worm.size();i++){
        if (this.worm.get(i).getX() == piece.getX() && this.worm.get(i).getY() == piece.getY()) {
            return true;
        }}
        return false;
    }

    public boolean runsIntoItself() {
        for (int i = 0; i < this.getLength() - 1; i++) {
            if (this.getHead().getX() == this.worm.get(i).getX() && this.getHead().getY() == this.worm.get(i).getY()) {
                return true;
            }
        }
        return false;
    }

    public Piece getHead() {
        return this.worm.get(getLength() - 1);
    }
}
