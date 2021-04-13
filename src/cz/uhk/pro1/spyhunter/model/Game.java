package cz.uhk.pro1.spyhunter.model;

import javax.sound.midi.Receiver;
import java.awt.*;

public class Game {
    private Tile[][] tiles;
    private int score;
    private boolean isDead;
    private int elapsedTime;
    private Car player = new Car();

    public int getScore()
    {
        return score;
    }
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
        int canvasHeight = 300;
        for (int i = elapsedTime/Tile.SIZE; i < canvasHeight/Tile.SIZE + elapsedTime/Tile.SIZE + 2; i++) {
            for (int j = 0; j < tiles[i % tiles.length].length; j++) {
                int x = j*Tile.SIZE;
                // +elapsedTime posunout silnici DOLU podle toho, jak ubiha cas
                // -i*Tile.SIZE nove dlazdice kreslit "pred" (nahoru "do minusu") stavajici
                // +canvasHeight zacit o celou vysku "okna" niz
                // pozn: kresli sachovnici vzhuru nohama
                int y = elapsedTime - i*Tile.SIZE + canvasHeight;
                Tile tile = tiles[i % tiles.length][j];
                tile.draw(g, x, y);
                // otestujeme, jestli auto nekoliduje s dlazdici
                Rectangle tilerect = new Rectangle(x,y,Tile.SIZE,Tile.SIZE);
                if(player.testCollision(tilerect)){
                    tile.action(this);
                }
            }
        }
        player.draw(g);
    }

    /**
     * Zaktualizuje herni stav (posuneme mapu, pohneme autem, aktualizovat skore, detekovat kolize)
     * Je volano casovacem kazdych x milisekund
     */
    public void update() {
        elapsedTime+= 1;
        //elapsedTime = 5;
        if(this.isDead){
            elapsedTime = 0;
        }
    }

    public void rideLeft(){
        player.move(-2);
    }
    public void rideRight(){
        player.move(2);
    }
}
