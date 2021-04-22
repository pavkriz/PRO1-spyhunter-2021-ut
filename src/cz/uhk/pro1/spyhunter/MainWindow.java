package cz.uhk.pro1.spyhunter;

import cz.uhk.pro1.spyhunter.model.*;
import cz.uhk.pro1.spyhunter.service.CsvMapLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;


public class MainWindow extends JFrame {
    private Game game = new Game();
    private final Timer timer = new Timer(20, e -> tick());
    private final JPanel gamePanel = new GamePanel();

    class GamePanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            //System.out.println(new Date()+" paint");
            super.paint(g);
            //g.drawLine(0,0, 100, 200);
            game.draw(g);
        }
    }

    public MainWindow() {
        setTitle("Spy Hunter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //p.setBackground(Color.BLACK);
        add(gamePanel, BorderLayout.CENTER);
        gamePanel.setDoubleBuffered(true); // potencialne plynulejsi animace
        gamePanel.setPreferredSize(new Dimension(300, 300));
        prepareGame();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    game.rideLeft();
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    game.rideRight();
                }
            }
        });

        timer.start();
        pack();
    }

    private void tick() {
        //System.out.println(new Date()+" tick!");
        // zmenime herni stav (posuneme mapu, pohneme autem, aktualizovat skore, detekovat kolize)
        game.update();
        // vyvolame prekresleni herni plochy na JPanelu
        gamePanel.repaint();
        // kvuli lagovani v Linuxu: Synchronizes this toolkit's graphics state. Some window systems may do buffering
        // of graphics events. This method ensures that the display is up-to-date. It is useful for animation.
        Toolkit.getDefaultToolkit().sync();
    }

    private void prepareGame() {
        // vyrobime pole s dlazdicemi a naplnime ho ruznymi druhy dlazdic
//        Tile[][] tiles = new Tile[20][30];
//        for (int row=0; row<tiles.length; row++)
//        {
//            for (int col=0; col<tiles[row].length;col++)
//            {
//                if (col==0 || col == tiles[row].length-1)
//                {
//                    tiles[row][col] = new GrassTile();
//                }
//                else {
//                    tiles[row][col] = new RoadTile();
//                }
//            }
//        }
//        tiles[5][5] = new BonusTile();
//        game.setTiles(tiles);
//        // pro kontrolu si pole "vypiseme"
//        game.dumpTiles();
        CsvMapLoader l = new CsvMapLoader();
        game = l.loadMap();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MainWindow w = new MainWindow();
            w.setVisible(true);
        });
    }
}
