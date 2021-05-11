package cz.uhk.pro1.spyhunter.model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Car {
    private int width;
    private int height;
    private int x;
    private int y;
    private Image image;

    public Car(int x, int y, Image img)
    {
        this.x = x;
        this.y = y;
        //image = ImageIO.read(new URL("https://lide.uhk.cz/fim/ucitel/krizpa1/pro2/spyhunter/car2.png"));
        image = img;
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public void move(int dx)
    {
        x += dx;
    }

    /**
     * Zjisti, zda auto koliduje s obdelnikem rect
     * @param rect obdelnik
     * @return true, pokud koliduje
     */
    public boolean testCollision(Rectangle rect)
    {
        Rectangle carRectangle = new Rectangle(x,y,width,height);
        return rect.intersects(carRectangle);
    }

    public void draw(Graphics g)
    {
        g.drawImage(image, x, y,null);
    }
}
