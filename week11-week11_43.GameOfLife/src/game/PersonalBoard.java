package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

public class PersonalBoard extends GameOfLifeBoard {

    private Random random;

    public PersonalBoard(int width, int height) {
        super(width, height);
        this.random = new Random();
    }

    public boolean isInRange(int x, int y) {
        if ((x >= 0 && x < super.getWidth()) && (y >= 0 && y < super.getHeight())) {
            return true;
        }
        return false;
    }

    public void turnToLiving(int x, int y) {
        if (this.isInRange(x, y)) {
            super.getBoard()[x][y] = true;
        }
    }

    public void turnToDead(int x, int y) {
        if (this.isInRange(x, y)) {
            super.getBoard()[x][y] = false;
        }
    }

    public boolean isAlive(int x, int y) {
        if (this.isInRange(x, y) && super.getBoard()[x][y]) {
            return true;
        }
        return false;
    }

    public void initiateRandomCells(double probabilityForEachCell) {
        for (int x = 0; x < super.getWidth(); x++) {
            for (int y = 0; y < super.getHeight(); y++) {
                if (new Random().nextDouble() < probabilityForEachCell) {
                    this.turnToLiving(x, y);
                }
            }
        }
    }

    public int getNumberOfLivingNeighbours(int x, int y) {
        int livingNeighbours = 0;
        for (int a = x - 1; a <= x + 1; a++) {
            for (int b = y - 1; b <= y + 1; b++) {
                if (this.isAlive(a, b)) {
                    livingNeighbours++;
                }
            }
        }
        if(this.isAlive(x, y)){
            livingNeighbours--;
        }
        return livingNeighbours;
    }

    public void manageCell(int x, int y, int livingNeighbours) {
        if (livingNeighbours < 2) {
            this.turnToDead(x, y);
        } else if(livingNeighbours==3){
            this.turnToLiving(x, y);
        } else if (livingNeighbours>3){
            this.turnToDead(x, y);
        }
    }
}
