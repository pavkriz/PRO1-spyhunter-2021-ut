package cz.uhk.pro1.spyhunter.model;

import java.awt.*;

public class RoadTile extends AbstractTile {

    public RoadTile(Image image) {
        super(image);
    }

    @Override
    public void action(Game g) {

    }

    @Override
    public void reactivate() {
        // nic nedelame
    }

    @Override
    public String toString() {
        return " ";
    }
}
