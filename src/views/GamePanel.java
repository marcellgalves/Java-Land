package views;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel {
    // SCREEN SETTINGS

    final int originalTileSize = 16; // 16x16
    final int scale = 4;
    final int tileSize = originalTileSize * scale; // 64x64

    final int maxScreenCol = 20;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 1280
    final int screenRow = tileSize * maxScreenRow; // 768

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenRow));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

}
