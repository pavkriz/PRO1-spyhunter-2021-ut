package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public class BonusTile implements Tile {
    // vykreslit na hraci plochu
    // vime, ze ma pridat 100 bodu do score
    private boolean isActive = true;
    private int bonusTilePoints;

    public void setBonusTilePoints(int bonusTilePoints) {
        this.bonusTilePoints = bonusTilePoints;
    }

    @Override
    public void action(Game g) {
        if(isActive) {
            System.out.println("Sezrali jsme bonus");
            g.setScore(g.getScore() + bonusTilePoints);
            isActive = false;
        }
    }

    @Override
    public void draw(Graphics g, int x, int y, int tileSize) {
        if (!isActive){
            g.setColor(Color.BLACK);
        }else {
            g.setColor(Color.YELLOW);
        }
            g.fillRect(x, y, tileSize, tileSize);

    }

    @Override
    public void reactivate() {
        isActive = true;
    }

    @Override
    public String toString() {
        return "@";
    }
}
