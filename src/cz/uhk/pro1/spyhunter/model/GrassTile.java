package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public class GrassTile extends AbstractTile {
    public GrassTile(Image image) {
        super(image);
    }

    @Override
    public void action(Game g) {
        System.out.println("Narazili jsme");
        g.setIsDead(true);
    }

    @Override
    public void reactivate() {
        // nic nedelame
    }

    @Override
    public String toString() {
        return "#";
    }
}
