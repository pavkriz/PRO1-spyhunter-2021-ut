package cz.uhk.pro1.spyhunter.model;

public class GrassTile implements Tile {
    @Override
    public void action(Game g) {
        g.setIsDead(true);
    }

    @Override
    public String toString() {
        return "#";
    }
}
