package cz.uhk.pro1.spyhunter;

import cz.uhk.pro1.spyhunter.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.Date;


public class MainWindow extends JFrame {
    private Game game = new Game();

    class GamePanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            System.out.println(new Date()+" paint");
            super.paint(g);
            //g.drawLine(0,0, 100, 200);
            game.draw(g);
        }
    }

    public MainWindow() {
        setTitle("Spy Hunter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 300));
        pack();
        JPanel p = new GamePanel();
        //p.setBackground(Color.BLACK);
        add(p, BorderLayout.CENTER);

        prepareGame();
    }

    private void prepareGame() {
        // vyrobime pole s dlazdicemi a naplnime ho ruznymi druhy dlazdic
        Tile[][] tiles = new Tile[20][30];
        for (int row=0; row<tiles.length; row++)
        {
            for (int col=0; col<tiles[row].length;col++)
            {
                if (col==0 || col == tiles[row].length-1)
                {
                    tiles[row][col] = new GrassTile();
                }
                else {
                    tiles[row][col] = new RoadTile();
                }
            }
        }
        tiles[5][5] = new BonusTile();
        game.setTiles(tiles);
        // pro kontrolu si pole "vypiseme"
        game.dumpTiles();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MainWindow w = new MainWindow();
            w.setVisible(true);
        });
    }
}
