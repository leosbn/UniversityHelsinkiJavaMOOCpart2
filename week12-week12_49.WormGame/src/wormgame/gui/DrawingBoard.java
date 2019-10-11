package wormgame.gui;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import wormgame.game.WormGame;
import wormgame.domain.*;

public class DrawingBoard extends JPanel implements Updatable {

    private WormGame game;
    private int pieceLength;

    public DrawingBoard(WormGame game, int pieceLength) {
        this.game = game;
        this.pieceLength=pieceLength;
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        
        for(Piece piece : this.game.getWorm().getPieces()){
            graphics.setColor(Color.BLACK);
            graphics.fill3DRect(piece.getX()*this.pieceLength, piece.getY()*this.pieceLength, this.pieceLength, this.pieceLength, true);
        }
        graphics.setColor(Color.red);
        graphics.fillOval(this.game.getApple().getX()*this.pieceLength, this.game.getApple().getY()*this.pieceLength, this.pieceLength, this.pieceLength);
    }
    
    public void update(){
        this.repaint();
    }
}
