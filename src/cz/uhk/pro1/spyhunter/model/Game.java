package cz.uhk.pro1.spyhunter.model;

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
}
