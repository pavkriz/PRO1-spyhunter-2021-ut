package cz.uhk.pro1.spyhunter.service;

import cz.uhk.pro1.spyhunter.model.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import cz.uhk.pro1.spyhunter.model.Game;
import cz.uhk.pro1.spyhunter.model.Tile;

import javax.imageio.ImageIO;
import java.net.URL;
import java.util.StringTokenizer;

public class CsvMapLoader {


    // radky
    // sloupce
    // hodnota bonus tile
    // sirka okna
    // vyska okna
    // timer ms
    // pocatecni poloha auta x
    // pocatecni poloha auta y
    // velikost dlazdice

    public Game loadMap() {
        Game generatedGame = new Game();
        try (BufferedReader br = new BufferedReader(new FileReader("map.csv"))) {
            String line = br.readLine();
            String[] row = line.split(";");

            int rows = Integer.parseInt(row[0]);
            int cols =  Integer.parseInt(row[1]);
            int bonusTilePoints =  Integer.parseInt(row[2]);
            int windowWidth =  Integer.parseInt(row[3]);
            int windowsHeight =  Integer.parseInt(row[4]);
            int time =  Integer.parseInt(row[5]);
            int startPositionX =  Integer.parseInt(row[6]);
            int startPositionY =  Integer.parseInt(row[7]);
            int tileSize =  Integer.parseInt(row[8]);

            line = br.readLine();
            String urlCar = line.split(";")[0];
            line = br.readLine();
            String urlRoad = line.split(";")[0];
            line = br.readLine();
            String urlGrass = line.split(";")[0];
            line = br.readLine();
            String urlBonusTile = line.split(";")[0];

            Image roadImg = ImageIO.read(new URL(urlRoad));
            Image grassImg = ImageIO.read(new URL(urlGrass));
            Image bonusImg = ImageIO.read(new URL(urlBonusTile));

            Tile[][] tiles = new Tile[rows][cols];

            for(int i = 0; i < rows; i++){
                line = br.readLine();
                String[] mapCols = line.split(";");
                for (int j = 0; j < mapCols.length; j++){
                    Tile tempTile;

                    switch (mapCols[j]) {
                        case "#":
                            tempTile = new GrassTile(grassImg);
                            break;
                        case "":
                            tempTile = new RoadTile(roadImg);
                            break;
                        case "@":
                            tempTile = new BonusTile();
                            ((BonusTile)tempTile).setBonusTilePoints(bonusTilePoints);
                            break;
                        default:
                            throw new RuntimeException("Unknown symbol in map CSV: " + mapCols[j]);
                    }

                    tiles[i][j] = tempTile;

                }
            }
            Image carImg = ImageIO.read(new URL(urlCar));

            generatedGame.setTiles(tiles);
            generatedGame.setPlayer(new Car(startPositionX, startPositionY, carImg));
            generatedGame.setHeight(windowsHeight);
            generatedGame.setWidth(windowWidth);
            generatedGame.setTileSize(tileSize);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return generatedGame;
    }
}
