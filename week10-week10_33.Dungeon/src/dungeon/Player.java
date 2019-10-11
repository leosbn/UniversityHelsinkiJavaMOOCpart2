package dungeon;

public class Player implements Mover {

    private int x;
    private int y;
    private String id;
    private int lenght;
    private int height;

    public Player(int length, int height) {
        this.x = 0;
        this.y = 0;
        this.id = "@";
        this.lenght = length;
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

    public void movePlayer(int[] command) {
        /*int moveUp = 0;
        int moveDown = 0;
        int moveLeft = 0;
        int moveRight = 0;
        for (int i = 0; i < command.length(); i++) {
            switch (command.charAt(i)) {
                case 'w':
                    moveUp++;
                    break;
                case 's':
                    moveDown++;
                    break;
                case 'a':
                    moveLeft++;
                    break;
                case 'd':
                    moveRight++;
                    break;
                default:
                    break;
            }
        }
        if (this.y + moveDown < this.height) {
            this.y += moveDown;
        }
        if (this.y - moveUp >= 0) {
            this.y -= moveUp;
        }
        if (this.x + moveRight < this.lenght) {
            this.x += moveRight;
        }
        if (this.x - moveLeft >= 0) {
            this.x -= moveLeft;
        }*/
    }
}
