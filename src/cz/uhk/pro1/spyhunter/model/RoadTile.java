package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public class RoadTile implements Tile {

    @Override
    public void action(Game g) {

    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.BLACK);
        g.fillRect(x,y, Tile.SIZE,Tile.SIZE);
    }

    @Override
    public String toString() {
        return " ";
    }
}
