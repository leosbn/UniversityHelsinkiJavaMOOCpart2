package dungeon;

public class Vampire implements Mover {

    private int x;
    private int y;
    private String id;
    private int length;
    private int height;

    public Vampire(int x, int y, int length, int height) {
        this.x = x;
        this.y = y;
        this.id = "v";
        this.length = length;
        this.height = height;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int newX) {
        this.x = newX;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    public String getId() {
        return this.id;
    }

    public String toString() {
        return this.id + " " + this.x + " " + this.y;
    }

    public boolean equals(Vampire o) {
        if (this.x == o.x && this.y == o.y) {
            return true;
        }
        return false;
    }

}
