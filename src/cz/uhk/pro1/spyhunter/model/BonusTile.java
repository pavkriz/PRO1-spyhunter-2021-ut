package cz.uhk.pro1.spyhunter.model;

public class BonusTile implements Tile {
    // vykreslit na hraci plochu
    // vime, ze ma pridat 100 bodu do score
    @Override
    public void action(Game g) {
        g.setScore(g.getScore() +50);
    }

    @Override
    public String toString() {
        return "@";
    }
}
