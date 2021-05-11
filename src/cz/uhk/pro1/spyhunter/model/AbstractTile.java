package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public abstract class AbstractTile implements Tile {
    Image image;

    public AbstractTile(Image image) {
        this.image = image;
    }

    @Override
    public void draw(Graphics g, int x, int y, int tileSize) {
        g.drawImage(image, x, y, null); // pozor, ignorujeme pozadovanou velikost dlazdice tileSize
    }
}
