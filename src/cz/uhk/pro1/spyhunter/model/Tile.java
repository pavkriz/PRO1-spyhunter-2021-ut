package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public interface Tile {
    // TODO boolean isColide(int i, int j);
    String toString();
    static final int SIZE = 30;
    void action(Game g);
    void draw(Graphics g, int x, int y);

    /**
     * Bude zavolano poprve, kdy se dlazdice (znovu) objevi na herni plose
     */
    void reactivate();
}
