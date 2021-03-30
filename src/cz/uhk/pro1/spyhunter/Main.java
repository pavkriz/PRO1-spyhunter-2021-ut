package cz.uhk.pro1.spyhunter;

import cz.uhk.pro1.spyhunter.model.*;

public class Main {
    public static void main(String[] args) {
        Game g = new Game();
        // vyrobime pole s dlazdicemi a naplnime ho ruznymi druhy dlazdic
        Tile[][] tiles = new Tile[20][30];
        for (int row=0; row<tiles.length; row++)
        {
            for (int col=0; col<tiles[row].length;col++)
            {
                if (col==0 || col == tiles[row].length-1)
                {
                    tiles[row][col] = new GrassTile();
                }
                else {
                    tiles[row][col] = new RoadTile();
                }
            }
        }
        tiles[5][5] = new BonusTile();
        g.setTiles(tiles);
        // pro kontrolu si pole "vypiseme"
        g.dumpTiles();
    }
}
