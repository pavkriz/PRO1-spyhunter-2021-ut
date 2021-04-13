package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public class GrassTile implements Tile {
    @Override
    public void action(Game g) {
        System.out.println("Narazili jsme");
        g.setIsDead(true);
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.GREEN);
        g.fillRect(x,y, Tile.SIZE,Tile.SIZE);
    }

    @Override
    public String toString() {
        return "#";
    }
}
