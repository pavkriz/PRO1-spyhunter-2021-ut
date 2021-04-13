package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public class BonusTile implements Tile {
    // vykreslit na hraci plochu
    // vime, ze ma pridat 100 bodu do score
    @Override
    public void action(Game g) {
        System.out.println("Sezrali jsme bonus");
        g.setScore(g.getScore() +50);
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        g.setColor(Color.YELLOW);
        g.fillRect(x,y, Tile.SIZE,Tile.SIZE);
    }

    @Override
    public String toString() {
        return "@";
    }
}
