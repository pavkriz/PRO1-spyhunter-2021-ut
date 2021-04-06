package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public class Game {
    private Tile[][] tiles;
    private int score;
    private boolean isDead;

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
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {

                int x = j*Tile.SIZE;
                int y = i*Tile.SIZE;
                Tile tile = tiles[i][j];
                tile.draw(g, x,y);
            }
        }
    }

}
