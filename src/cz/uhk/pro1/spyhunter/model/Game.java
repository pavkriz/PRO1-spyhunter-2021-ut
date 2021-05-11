package cz.uhk.pro1.spyhunter.model;

import javax.sound.midi.Receiver;
import java.awt.*;

public class Game {
    private Tile[][] tiles;
    private int score;
    private int width;
    private int height;
    private boolean isDead;
    private int elapsedTime;
    private Car player;
    private int tileSize;

    public void setTileSize(int tileSize){this.tileSize=tileSize;}
    public int getScore()
    {
        return score;
    }
    public void setWidth(int width) { this.width = width;}
    public int getWidth() {return width;}
    public void setHeight(int height) { this.height = height;}
    public int getHeight() {return height;}
    public void setScore(int score)
    {
        this.score = score;
    }
    public void setTiles(Tile[][] tiles)
    {
        this.tiles = tiles;
    }
    public void setIsDead(Boolean isDead)
    {
        this.isDead = isDead;
    }
    public void setPlayer(Car player){
        this.player = player;
    }

    public Tile[][] getTiles()
    {
        return tiles;
    }
    public void dumpTiles()
    {
        for (int row=0; row<tiles.length; row++)
        {
            for (int col=0; col<tiles[row].length;col++)
            {
                System.out.print(tiles[row][col]);
            }
            System.out.println();
        }
    }

    public void draw(Graphics g) {
        int canvasHeight = height;
        for (int i = elapsedTime/tileSize; i < canvasHeight/tileSize + elapsedTime/tileSize + 2; i++) {
            for (int j = 0; j < tiles[i % tiles.length].length; j++) {
                int x = j*tileSize;
                // +elapsedTime posunout silnici DOLU podle toho, jak ubiha cas
                // -i*tileSize nove dlazdice kreslit "pred" (nahoru "do minusu") stavajici
                // +canvasHeight zacit o celou vysku "okna" niz
                // pozn: kresli sachovnici vzhuru nohama
                int y = elapsedTime - i*tileSize + canvasHeight;
                Tile tile = tiles[i % tiles.length][j];
                tile.draw(g, x, y,tileSize);
                // otestujeme, jestli auto nekoliduje s dlazdici
                Rectangle tilerect = new Rectangle(x,y,tileSize,tileSize);
                if(player.testCollision(tilerect)){
                    tile.action(this);
                }
                if (i == canvasHeight/tileSize + elapsedTime/tileSize + 2 - 1) {
                    // kreslim prvni (horni) radek sachovnice
                    // reaktiovovat pripadne bonusy
                    tile.reactivate();
                }
            }
        }
        g.setColor(Color.white);
        g.drawString("Score: " + score, 10, 10);
        player.draw(g);
    }

    /**
     * Zaktualizuje herni stav (posuneme mapu, pohneme autem, aktualizovat skore, detekovat kolize)
     * Je volano casovacem kazdych x milisekund
     */
    public void update() {
        //elapsedTime = 5;
        if(!this.isDead){
            elapsedTime+= 1;
        }
    }

    public void rideLeft(){
        player.move(-2);
    }
    public void rideRight(){
        player.move(2);
    }
}
