package dungeon;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Dungeon {

    private int length;
    private int height;
    private int vampires;
    private int moves;
    private boolean vampiresMove;
    private Random random;
    private Player player;
    private ArrayList<Vampire> allVampires;
    private Scanner scanner;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        //creating grid and data
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.random = new Random();
        this.allVampires = new ArrayList<Vampire>();
        this.player = new Player(this.length, this.height);
        //creating vampires that don't step on eachothers feet
        Vampire v = new Vampire(this.random.nextInt(this.length), this.random.nextInt(this.height), this.length, this.height);
        this.allVampires.add(v);
        for (int i = 1; i < this.vampires; i++) {
            int possibleX = this.random.nextInt(this.length);
            int possibleY = this.random.nextInt(this.height);
            boolean isOk = true;
            for (Vampire vampAlreadyInList : this.allVampires) {
                if (vampAlreadyInList.getX() == possibleX && vampAlreadyInList.getY() == possibleY) {
                    isOk = false;
                }
            }
            if (isOk) {
                Vampire v2 = new Vampire(possibleX, possibleY, this.length, this.height);
                this.allVampires.add(v2);
            } else {
                possibleX = 1 + this.random.nextInt(this.length - 1);
                possibleY = 1 + this.random.nextInt(this.height - 1);
            }
        }
        this.scanner = new Scanner(System.in);
    }

    public void showVampires() {
        for (Vampire v : this.allVampires) {
            System.out.println(v);
        }
    }

    public void run() {
        while (true) {
            if (this.moves == 0) {
                System.out.println("YOU LOSE");
                break;
            }
            this.checkVampiresPositions();
            this.showStatus();
            this.showTable();
            if (this.allVampires.isEmpty()) {
                System.out.println("YOU WIN");
                break;
            }
            this.inputMovePlayer();
            this.moveVampires();
        }
    }

    public void printParticipants() {
        System.out.println(player);
        for (Vampire vamp : this.allVampires) {
            System.out.println(vamp);
        }
    }

    public void showStatus() {
        System.out.println(this.moves);
        System.out.println("");
        this.printParticipants();
        System.out.println("");
        this.moves--;
    }

    public void showTable() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.length; j++) {
                String tile = "";

                if (j == player.getX() && i == player.getY()) {
                    tile += player.getId();
                }
                for (Vampire vamp : this.allVampires) {
                    if (j == vamp.getX() && i == vamp.getY()) {
                        tile += vamp.getId();
                    }
                }
                if (tile.equals("@")) {
                    System.out.print("@");
                } else if (tile.equals("v")) {
                    System.out.print("v");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println("");
        }
    }

    public void inputMovePlayer() {
        System.out.println("");
        String input = this.scanner.nextLine();
        int moveUp = 0;
        int moveDown = 0;
        int moveLeft = 0;
        int moveRight = 0;
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
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
        for (int z = 0; z < moveDown; z++) {
            if (this.player.getY() + 1 < this.height) {
                this.player.setY(this.player.getY() + 1);
            }
        }
        /*if (this.player.getY() + moveDown < this.height) {
            this.player.setY(this.player.getY() + moveDown);
        }*/
        this.checkVampiresPositions();
        for (int b = 0; b < moveUp; b++) {
            if (this.player.getY() - 1 >= 0) {
                this.player.setY(this.player.getY() - 1);
            }
        }
        this.checkVampiresPositions();
        for (int n = 0; n < moveRight; n++) {
            if (this.player.getX() + 1 < this.length) {
                this.player.setX(this.player.getX() + 1);
            }
        }
        this.checkVampiresPositions();
        for (int m = 0; m < moveLeft; m++) {
            if (this.player.getX() - 1 >= 0) {
                this.player.setX(this.player.getX() - 1);
            }
        }
        this.checkVampiresPositions();
    }

    public void checkVampiresPositions() {
        ArrayList<Vampire> vampiresToDelete = new ArrayList<Vampire>();
        for (Vampire vamp : this.allVampires) {
            if (vamp.getX() == this.player.getX() && vamp.getY() == this.player.getY()) {
                vampiresToDelete.add(vamp);
            }
        }
        this.allVampires.removeAll(vampiresToDelete);
    }

    public boolean ifVampiresMove() {
        return this.vampiresMove;
    }

    public void moveVampires() {
        //if vampires move (decided by constructor
        if (this.ifVampiresMove()) {
            //for each vampire...
            for (Vampire vampire : this.allVampires) {
                //create to variables to hold new position
                int possibleNewX = this.random.nextInt(this.length);
                int possibleNewY = this.random.nextInt(this.height);
                //check if any other vampire already has those coordinates
                boolean thisVampireCanMove = true;
                for (Vampire vampire1 : this.allVampires) {
                    if (vampire1.getX() == possibleNewX || vampire1.getY() == possibleNewY) {
                        thisVampireCanMove = false;
                    }
                }
                if (thisVampireCanMove) {
                    vampire.setX(possibleNewX);
                    vampire.setY(possibleNewY);
                }
            }
        }
    }
}
