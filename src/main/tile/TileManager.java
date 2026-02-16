package main.tile;

import main.views.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gamePanel;
    Tile[] tiles;
    int mapTileNum[][];
    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        tiles = new Tile[10];
        mapTileNum = new int[gamePanel.maxScreenCol * 2][gamePanel.maxScreenRow * 2];

        getTileImage();
        loadMap();
    }

    public void getTileImage() {

        try {

            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_tiles.png"));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water_tiles.png"));

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_tiles.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadMap(){
        try {
            InputStream is = getClass().getResourceAsStream("/maps/map01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow) {
                String line = br.readLine();

                while (col < gamePanel.maxScreenCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum [col] [row] = num;
                    col++;

                }
                if (col == gamePanel.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {


        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        int totalCols = gamePanel.maxScreenCol * 2;
        int totalRows = gamePanel.maxScreenRow * 2;
        int size = gamePanel.tileSize / 2;

        while (col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow) {

            while (col < totalCols && row < totalRows) {
                int tileNum = mapTileNum[col][row];
                g2.drawImage(tiles[tileNum].image, x, y, size, size, null);

                col++;
                x += size;

                if (col == totalCols) {
                    col = 0;
                    x = 0;
                    row++;
                    y += size;
                }
            }

        }
    }
}
